package com.java8.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {


    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        Runnable task = ()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("scheduled:"+System.nanoTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };


        //延迟3秒执行
        /*
        ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(task,3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);

        long remainingDelay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);

        System.out.printf("Remaining Delay: %sms", remainingDelay);
        */

        //每隔1秒 执行一次 没有延迟 不考虑实际情况会执行几秒
        /*
        int initialDelay = 0;
        int period = 1;
        scheduledExecutorService.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(5);

        scheduledExecutorService.shutdown();*/

        // 没有延迟 在执行完成后1秒 执行下一次任务 一般在 不能预测调度任务的执行时长时 使用
        int initialDelay = 0;
        int period = 1;

        scheduledExecutorService.scheduleWithFixedDelay(task,initialDelay,period,TimeUnit.SECONDS);


    }

}
