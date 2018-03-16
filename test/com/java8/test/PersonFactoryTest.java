package com.java8.test;

import com.java8.study.Person;
import com.java8.study.PersonFactory;

public class PersonFactoryTest {


    public static void main(String[] args) {

        PersonFactory<Person> personFactory = Person::new;

        Person person = personFactory.create("chen", "hao",12);

        System.out.println(person);

    }


}
