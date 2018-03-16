package com.java8.study;

public interface Converter<F,T> {

    T convert(F from);

}
