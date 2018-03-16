package com.java8.test;

import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> task = () -> {

            TimeUnit.SECONDS.sleep(1);

            return 123;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(task);


        System.out.println("future done? " + future.isDone());

        Integer result = future.get();

        System.out.println("future done? " + future.isDone());

        System.out.print("result: " + result);

        if(!executorService.isTerminated()){
            executorService.shutdown();
        }


    }


}
