package com.pobitecoding.algorithm.collection;

import java.net.PortUnreachableException;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    
    public static void main(String[] args) {
        
        Person person1 = new Person();
        person1.name = "홍길동";
        
        Person person2 = new Person();
        person2.name = "한석봉";
        
        Map<Person, Integer> persons = new HashMap();
        persons.put(person1, 20);
        persons.put(person2, 25);
        
        for (Person key: persons.keySet()) {
            int value = persons.get(key);
            System.out.println(key.name + "의 나이는 " + value);
        }
    }
}