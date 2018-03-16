package com.java8.test;

import com.java8.study.Person;
import com.java8.study.PersonFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectTest {

    public static void main(String[] args) {


        PersonFactory personFactory = Person::new;

        Person p1 = personFactory.create("chen","hao",28);
        Person p2 = personFactory.create("li","si",27);
        Person p3 = personFactory.create("zhang","san",30);
        Person p4 = personFactory.create("wang","er",28);
        Person p5 = personFactory.create("zhao","wu",27);


        List<Person> personList = Arrays.asList(p1,p2,p3,p4,p5);

        Map<Integer, List<Person>> personsByAge = personList.stream().collect(Collectors.groupingBy(p->p.getAge()));


        personsByAge.forEach((age,p)->System.out.format("age %s: %s\n", age, p));





    }



}
