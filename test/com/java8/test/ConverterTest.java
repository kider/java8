package com.java8.test;

import com.java8.study.Converter;

public class ConverterTest {

    public static void main(String[] args) {

//        Converter<String,Integer> converter = (from) -> Integer.valueOf(from);
//
//        Integer converted = converter.convert("123");
//
//        System.out.println(converted);

//        Converter<String,Integer> converter = Integer::valueOf;
//
//        Integer converted = converter.convert("123");
//
//        System.out.println(converted);

        final int num = 1;

        Converter<Integer,String> converter = (from )->String.valueOf(from +num);

        String converted = converter.convert(123);

        System.out.println(converted);




    }

}
