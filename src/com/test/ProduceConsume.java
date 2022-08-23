package com.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ProduceConsume
 * @Description 生产者 消费者
 * @Author kider
 * @Date 2020/3/18 11:34
 * @Version 1.0
 **/
public class ProduceConsume {


    private ReentrantLock reentrantLock = new ReentrantLock();

    private Condition condition = reentrantLock.newCondition();

    private Integer number = 0;


    /**
     * 生产
     */
    public void produce() {
        try {
            reentrantLock.lock();
            //没有的时候 生产
            while (0 != number) {
                condition.await();
            }
            number++;
            System.out.println("线程：" + Thread.currentThread().getName() + " 生产" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }


    public void consume() {
        try {
            reentrantLock.lock();
            //没有的时候 不再消费
            while (0 == number) {
                condition.await();
            }
            number--;
            System.out.println("线程：" + Thread.currentThread().getName() + " 消费" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }


    }


    public static void main(String[] args) {

        ProduceConsume produceConsume = new ProduceConsume();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                produceConsume.produce();
            }
        }, "produce1").start();


        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                produceConsume.produce();
            }
        }, "produce2").start();


        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                produceConsume.consume();
            }
        }, "consume1").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                produceConsume.consume();
            }
        }, "consume2").start();


    }


}
