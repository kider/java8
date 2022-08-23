package com.java8.study.inter;

/**
 * 测试接口
 *
 * @author chenh
 * @version 1.0
 * @date 2022/8/23 16:17
 **/
public class TestInterface implements InterfaceOne, InterfaceTwo {

    @Override
    public void method2() {
        System.out.println("TestInterface method2");
    }

    @Override
    public void method3() {
        System.out.println("TestInterface method3");
    }

    public static void main(String[] args) {
        TestInterface testInterface = new TestInterface();
        //静态方法直接调用
        InterfaceOne.method1();
        //两个默认相同的方法 需要重写
        testInterface.method2();
        //一般默认方法
        testInterface.method4();
        //一般接口方法
        testInterface.method3();
    }
}
