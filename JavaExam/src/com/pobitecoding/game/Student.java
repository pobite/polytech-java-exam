package com.pobitecoding.game;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int id;
    private String name;

    

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        return Objects.equals(name, other.name);
    }
    
//    // sort 규칙 재정의(오버라이드)
//    @Override
//    public int compareTo(Student o) {
//        return (id < o.id) ? -1 : ((id == o.id) ? 0 : 1);
//    }
    
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name) * - 1;
    }
}