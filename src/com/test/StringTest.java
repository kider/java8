package com.test;

/**
 * 字符串测试
 *
 * @author chenh
 * @version 1.0
 * @date 2022/11/9 12:49
 **/
public class StringTest {

    public static void method1() {
        String s1 = "chenhao";
        String s2 = "chenhao";
        System.out.println(s1 == s2);
        System.out.println("============");
    }

    public static void method2() {
        String s3 = "chen";
        String s4 = new String("chen");
        String s5 = s4.intern();
        String s6 = "chen";
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s5 == s6);
        System.out.println("============");
    }

    public static void method3() {
        String s7 = new String("hao");
        String s8 = s7.intern();
        String s9 = "hao";
        System.out.println(s7 == s8);
        System.out.println(s8 == s9);
        System.out.println("============");
    }

    public static void method4() {
        String s10 = "ch".intern();
        String s11 = new String("ch");
        String s12 = "ch";
        System.out.println(s10 == s11);
        System.out.println(s11 == s12);
        System.out.println(s10 == s12);
        System.out.println("============");
    }


    public static void main(String[] args) {
        /*method1();
        method2();
        method3();
        method4();*/

        int i2 = 2;//10
        int i3 = 1;//01
        int i4 = 4;//100
        int i5 = 3;//011

        /*System.out.println(Integer.toBinaryString(i2));
        System.out.println(Integer.toBinaryString(i3));
        System.out.println(Integer.toBinaryString(i4));
        System.out.println(Integer.toBinaryString(i5));

        System.out.println(Integer.toBinaryString(i5 & i4));*/

        System.out.println(StringTest.class.getClassLoader());
    }


}
