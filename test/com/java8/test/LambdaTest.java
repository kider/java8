package com.java8.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("d","a","b","c");


//        Collections.sort(list,new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return a.compareTo(b);
//            }
//        });
//
//
//        Collections.sort(list,(String a,String b) ->{
//            return a.compareTo(b);
//        });
//
//        Collections.sort(list,(String a,String b) -> a.compareTo(b));


        Collections.sort(list,(a,b) -> a.compareTo(b));


        System.out.println(list.toString());


    }

}
