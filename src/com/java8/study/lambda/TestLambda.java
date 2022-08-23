package com.java8.study.lambda;

/**
 * test Lambda
 *
 * @author chenh
 * @version 1.0
 * @date 2022/8/23 17:06
 **/
public class TestLambda {

    public static void main(String[] args) {
        MyLambdaInterface.lambdaInterfaceDemo(() -> System.out.println("自定义函数式接口"));
    }

}
