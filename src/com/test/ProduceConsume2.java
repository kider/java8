package com.test;

/**
 * @ClassName ProduceConsume
 * @Description 生产者 消费者
 * @Author kider
 * @Date 2020/3/18 11:34
 * @Version 1.0
 **/
public class ProduceConsume2 {


    private Object obj = new Object();

    private Integer number = 0;


    /**
     * 生产
     */
    public void produce() {
        synchronized (obj) {
            try {
                while (0 != number) {
                    System.out.println("生产线程：" + Thread.currentThread().getName() + " wait,当前number:" + number);
                    obj.wait();
                }
                number++;
                System.out.println("线程：" + Thread.currentThread().getName() + " 生产" + number);
                obj.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void consume() {
        synchronized (obj) {
            try {
                while (0 == number) {
                    System.out.println("消费线程：" + Thread.currentThread().getName() + " wait,当前number:" + number);
                    obj.wait();
                }
                System.out.println("线程：" + Thread.currentThread().getName() + " 消费" + number);
                number--;
                obj.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        ProduceConsume2 produceConsume = new ProduceConsume2();

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
