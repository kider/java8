package com.concurrent;

/**
 * 查看class字节码内容
 *
 * 执行以下命令
 * javac
 * javap -c -s -v -l
 *
 * @author chenh
 * @version 1.0
 * @date 2022/12/28 10:47
 **/
public class SynchronizedTest {

    private volatile int state = 0;

    private Object lock = new Object();

    public boolean getLock() {

        if (1 == state) return false;

        synchronized (lock) {
            if (0 == state) {
                state = 1;
                return true;
            }
        }
        return false;
    }

    public boolean releaseLock() {

        if (0 == state) return false;

        synchronized (lock) {
            if (1 == state) {
                state = 0;
                return true;
            }
        }
        return false;
    }

    public synchronized int getState() {
        return state;
    }

}
