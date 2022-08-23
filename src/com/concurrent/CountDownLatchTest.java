package com.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 *
 * @author chenhao26
 * @version 1.0
 * @date 2019/12/9 15:55
 **/
public class CountDownLatchTest {


    static class CountDownLatchTherad extends Thread {

        CountDownLatch cdl;

        private CountDownLatchTherad() {

        }

        public CountDownLatchTherad(CountDownLatch cdl) {
            this.cdl = cdl;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " sleep 1000");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cdl.countDown();
            System.out.println(Thread.currentThread().getName() + " countDown");

        }
    }


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new CountDownLatchTherad(cdl).start();
        }
        System.out.println("count Down await");
        cdl.await();
        System.out.println("count Down end");

    }
}
