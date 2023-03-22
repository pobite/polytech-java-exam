package com.pobitecoding.collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    
    public static void main(String[] args) {
        
        Person person1 = new Person();
        person1.name = "홍길동";
        
        Person person2 = new Person();
        person2.name = "한석봉";
        
        List<Person> peoples = new ArrayList<>();
        peoples.add(person1);
        peoples.add(person2);
        
        for (Person people : peoples) {
            System.out.println(people.name);
        }
    }
}