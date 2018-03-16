package com.java8.test;

import java.util.ArrayList;
import java.util.List;

public class StreamsTest {


    public static void main(String[] args) {

        List<String> strings = new ArrayList<String>();
        strings.add("a1");
        strings.add("a2");
        strings.add("a3");
        strings.add("b1");
        strings.add("b2");
        strings.add("b3");
        strings.add("c1");
        strings.add("c2");
        strings.add("c3");
        strings.add("a0");

//        strings.stream().filter((a) -> a.startsWith("a")).forEach(System.out::println);
        //sorted只是创建一个流对象排序的视图 不改变集合内的元素位置
//        strings.stream().sorted().filter((a) -> a.startsWith("a")).forEach(System.out::println);
//
//        System.out.println(strings);
//
//        strings.stream().map(String::toUpperCase).filter((a) -> a.startsWith("a")).forEach(System.out::println);
//
//        System.out.println(strings);

        boolean b = strings.stream().map(String::toUpperCase).anyMatch(a -> a.startsWith("A"));

        System.out.println(b);



    }




}
