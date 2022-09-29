package com.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ConcurrentUtils {

    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("termination interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }


    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("4");
        lists.add("5");
        lists.add("6");
        lists.add("7");


        Iterator<String> iterator = lists.iterator();

        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("3")) {
                iterator.remove();
                continue;
            }
            System.out.println(str);
        }


    }

}
