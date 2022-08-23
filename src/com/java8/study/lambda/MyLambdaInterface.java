package com.java8.study.lambda;

/**
 * Lambda
 *
 * @author chenh
 * @version 1.0
 * @date 2022/8/23 17:00
 **/
@FunctionalInterface
public interface MyLambdaInterface {

    void method1();


    /**
     * 函数式接口参数
     *
     * @param i
     */
    static void lambdaInterfaceDemo(MyLambdaInterface i) {
        i.method1();
    }


}
