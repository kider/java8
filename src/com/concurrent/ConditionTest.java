package com.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author chenhao26
 * @version 1.0
 * @date 2019/12/10 10:33
 **/
public class ConditionTest {


    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition condition = reentrantLock.newCondition();

    static class ConditionThread extends Thread {

        @Override
        public void run() {
            System.out.println("ConditionThread run");
            reentrantLock.lock();
            try {
                System.out.println("ConditionThread sleep 5s");
                sleep(5000);
                condition.signal();
                System.out.println("condition signal");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                reentrantLock.unlock();
            }

        }
    }


    public static void main(String[] args) {

        ConditionThread conditionThread = new ConditionThread();

        reentrantLock.lock();
        System.out.println("conditionThread start");
        conditionThread.start();
        try {
            System.out.println("mainThread sleep 5s");
            Thread.sleep(5000);
            System.out.println("mainThread block");
            condition.await();
            System.out.println("mainThread continue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }


}
