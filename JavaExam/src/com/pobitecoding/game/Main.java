package com.pobitecoding.game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class StudentIdAscComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}

class StudentNameAscComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


public class Main {

    public static void main(String[] args) {
        
        List<Student> students = new ArrayList<>();
        // 삽입 생략
        students.sort(new StudentIdAscComparator());
        
        // 익명클래스
        // 추상클래스인데 new하는 순간 완성할 게라는 뜻
        // 이 순간에만 딱 만들어지는 클래스
        Asset asset = new Asset("aaa", 100) {
            
        };
        
        // 미리 만들어 놓고 sort하는 게 아니라
        // 즉흥적으로 할 수 있음
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        
    }
}