package com.java8.study.inter;

/**
 * 测试接口
 *
 * @author chenh
 * @version 1.0
 * @date 2022/8/23 16:16
 **/
public interface InterfaceTwo {


    default void method2() {
        System.out.println("InterfaceTwo method2");
    }


    default void method4() {
        System.out.println("InterfaceTwo method4");
    }

}
