package com.java8.test;

import com.java8.study.Formula;

public class InterfaceTest {

    public static void main(String[] args) {


        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a);
            }
        };

        System.out.println(formula.calculate(100));

        System.out.println(formula.sqrt(100));

    }

}
