package com.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏
 *
 * @author chenhao26
 * @version 1.0
 * @date 2019/12/9 15:27
 **/
public class CyclicBarrierTest {


    static class CyclicBarrierThread extends Thread {

        CyclicBarrier cyclicBarrier;

        private CyclicBarrierThread() {

        }

        public CyclicBarrierThread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;

        }

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + "wait cyclicBarrier");

            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + "continued");
                System.out.println(Thread.currentThread().getName() + "umberWaiting:" + cyclicBarrier.getNumberWaiting());
                System.out.println(Thread.currentThread().getName() + "Parties" + cyclicBarrier.getParties());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        for (int i = 0; i < 10; i++) {
            new CyclicBarrierThread(cyclicBarrier).start();
        }
    }

}
