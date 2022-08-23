package com.java8.study.inter;

/**
 * 测试接口
 *
 * @author chenh
 * @version 1.0
 * @date 2022/8/23 16:11
 **/
public interface InterfaceOne {

    static void method1() {
        System.out.println("InterfaceOne method1");
    }

    default void method2() {
        System.out.println("InterfaceOne method2");
    }

    void method3();

}
