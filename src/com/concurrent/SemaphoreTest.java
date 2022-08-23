package com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 *
 * @author chenhao26
 * @version 1.0
 * @date 2019/12/9 14:24
 **/
public class SemaphoreTest {


    static class SemaphoreThread extends Thread {

        Semaphore sem;

        int count;

        private SemaphoreThread() {

        }

        public SemaphoreThread(Semaphore sem, int count) {
            this.sem = sem;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                sem.acquire(count);

                Thread.sleep(2000);

                System.out.println(Thread.currentThread().getName() + " acquire count=" + count);


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                sem.release(count);
                System.out.println(Thread.currentThread().getName() + " release " + count + "");
            }

        }
    }


    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(12);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new SemaphoreThread(semaphore, 7));

        executorService.submit(new SemaphoreThread(semaphore, 4));

        executorService.submit(new SemaphoreThread(semaphore, 2));


        executorService.shutdown();

    }


}
