package com.pobitecoding.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        List<String> strs = new ArrayList<>();
        strs.add("이동학");
        strs.add("박경덕");
        strs.add("강태근");
        strs.add("최유림");
        
        Collections.sort(strs);
        System.out.println(strs);
        
        
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(1);
        nums.add(8);
        nums.add(2);
        
        Collections.sort(nums);
        System.out.println(nums);
        
        
        
        // 내가 만든 클래스
        
        List<Student> students = new ArrayList<>();

        students.add(new Student(0, "이동학"));
        students.add(new Student(1, "박경덕"));
        students.add(new Student(2, "강태근"));
        students.add(new Student(3, "최유림"));
        
        Collections.sort(students);
        System.out.println(students);
    }
}