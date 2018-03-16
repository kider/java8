package com.java8.study;

@FunctionalInterface
public interface PersonFactory<T extends Person> {

//    T create(String firstName,String lastName);

    T create(String firstName,String lastName,int age);

}
