package com.pobitecoding.Serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    
    // 직렬화
    public static void main(String[] args) {
        
        Department department = new Department("총무부");
        Employee employee = new Employee("홍길동", 41);
        department.setLeader(employee);
        
        try (FileOutputStream fos = new FileOutputStream("company.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(department);
            oos.flush();
            oos.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}