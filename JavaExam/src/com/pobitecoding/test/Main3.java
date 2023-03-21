package com.pobitecoding.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3 {
    
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        
        // for each가 컨슈머를 받음
        // 리턴이 void여야 함
        // void가 리턴인 것을 수행하면 됨
        
        // 안에 들어온 것을 하나씩 받아서 print
        nums.stream().forEach((num) -> {
            System.out.println(num);
        });
        
        // 줄이기
        nums.stream().forEach((num) -> System.out.println(num));
        
        // 더 줄이기
        nums.stream().forEach(System.out::println);
        
    }
}