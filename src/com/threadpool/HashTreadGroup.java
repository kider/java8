package com.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * hash线程组
 */
public class HashTreadGroup extends AbstractExecutorService {

    private final ExecutorService[] group;

    private final int coreSize;
    private final int mask;
    private final boolean power2;
    private static final ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();
    // -1: running, 0: shutdown, 3: terminate
    private volatile int state = -1;
    private static final int RUNNING = -1;
    private static final int SHUTDOWN = 0;
    private static final int STOP = 1;
    private static final int TIDYING = 2;
    private static final int TERMINATED = 3;
    private static final AtomicIntegerFieldUpdater<HashTreadGroup> stateUpdater = AtomicIntegerFieldUpdater
            .newUpdater(HashTreadGroup.class, "state");

    public HashTreadGroup(int coreSize) {
        this(coreSize, defaultThreadFactory);
    }

    public HashTreadGroup(int coreSize, ThreadFactory factory) {
        this.coreSize = coreSize;
        this.mask = coreSize - 1;
        power2 = (coreSize & (coreSize - 1)) == 0;
        group = new ThreadPoolExecutor[coreSize];
        for (int i = 0; i < coreSize; i++) {
            group[i] = createThreadExecutor(factory);
        }
    }

    @Override
    public void shutdown() {
        advanceRunState(SHUTDOWN);
        if (group == null || group.length == 0) {
            advanceRunState(TERMINATED);
            return;
        }
        for (ExecutorService executor : group) {
            executor.shutdown();
        }
    }

    @Override
    public List<Runnable> shutdownNow() {
        advanceRunState(STOP);
        List<Runnable> list = new ArrayList<>(0);
        if (group == null || group.length == 0) {
            advanceRunState(TERMINATED);
            return list;
        }
        for (ExecutorService executor : group) {
            list.addAll(executor.shutdownNow());
        }
        return list;
    }

    @Override
    public boolean isShutdown() {
        return state > RUNNING;
    }

    @Override
    public boolean isTerminated() {
        return state >= TERMINATED;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        if (group == null || group.length == 0) {
            advanceRunState(TERMINATED);
            return true;
        }
        boolean result = true;
        long timeoutPer = unit.toNanos(timeout) / coreSize;
        for (ExecutorService executor : group) {
            try {
                executor.awaitTermination(timeoutPer, TimeUnit.NANOSECONDS);
            } catch (Exception e) {
                // swallow exception
                result = false;
            }
        }
        advanceRunState(TERMINATED);
        return result;
    }

    @Override
    public void execute(Runnable r) {
        Objects.requireNonNull(r);
        ExecutorService service = next(r);
        service.execute(r);
    }

    protected ExecutorService next(Runnable runnable) {
        if (power2) {
            return group[hash(runnable) & mask];
        }
        return group[hash(runnable) % coreSize];
    }

    protected int hash(Runnable command) {
        Runnable target = command;
        if (target instanceof HashRunnable) {
            return ((HashRunnable) target).hash();
        }
        return Objects.hashCode(target);
    }

    protected ExecutorService createThreadExecutor(ThreadFactory factory) {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), factory);
    }

    private void advanceRunState(int targetState) {
        for (; ; ) {
            if (state >= targetState || stateUpdater.compareAndSet(this, state, targetState)) {
                break;
            }
        }
    }
}
