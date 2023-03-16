package com.pobitecoding.game;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        
//        List<Student> 장학생명부 = new ArrayList();
//        
//        Student 반장 = new Student("이동학");
//        장학생명부.add(반장);
//        System.out.println(장학생명부);
//        
//        반장 = new Student("이동학");
//        
//        // 높은 사람
//        장학생명부.remove(반장);   // 박경덕
//        System.out.println(장학생명부);
        
        
        Set<Student> 장학생명부 = new HashSet();
        
        Student 반장 = new Student("이동학");
        장학생명부.add(반장);
        
        System.out.println(반장.hashCode());
        System.out.println(장학생명부);
        
        
        반장 = new Student("이동학");
        System.out.println(반장.hashCode());
        
        // 높은 사람
        장학생명부.remove(반장);   // 박경덕
        System.out.println(장학생명부);
        
    }
}