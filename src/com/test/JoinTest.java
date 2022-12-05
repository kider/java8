package com.test;

/**
 * @author chenh
 * @version 1.0
 * @date 2022/11/10 14:14
 **/
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread2;
        Thread thread1;
        thread1 = new Thread(() -> {
            System.out.println("1");
        });
        thread2 = new Thread(() -> {
            System.out.println("2");
        });
        thread2.join();
        thread2.start();
        thread1.start();
        thread1.join();
        System.out.println("3");
    }
}
