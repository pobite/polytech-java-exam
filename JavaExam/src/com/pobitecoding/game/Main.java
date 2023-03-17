package com.pobitecoding.game;

import java.util.ArrayList;
import java.util.Collections;
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
    }
}