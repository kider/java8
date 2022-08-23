package com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class LockTest {

    //互斥锁
    static ReentrantLock lock = new ReentrantLock();

    static int count = 0;

   synchronized void increment(){
        count = count + 1;
    }

    void incrementReentrantLock(){
        lock.lock();
     try {
         count = count + 1;
     }finally {
         lock.unlock();
     }
    }


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.range(0,100000).forEach(i->executorService.submit(()->{
            LockTest lockTest = new LockTest();
//            lockTest.increment();
            lockTest.incrementReentrantLock();
        }));


        ConcurrentUtils.stop(executorService);

        System.out.println(count);


    }




}
