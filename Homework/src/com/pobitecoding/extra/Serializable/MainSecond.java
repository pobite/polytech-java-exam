package com.pobitecoding.extra.Serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainSecond {
    
    // 복원
    public static void main(String[] args) {
        
        try (FileInputStream fis = new FileInputStream("company.dat")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Department department = (Department) ois.readObject();
            System.out.println(department.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
