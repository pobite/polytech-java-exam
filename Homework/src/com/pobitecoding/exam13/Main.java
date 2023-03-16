package com.pobitecoding.exam13;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        List<Y> alpabets = new ArrayList<>();
        
        Y obj1 = new A();
        Y obj2 = new B();
        
        alpabets.add(obj1);
        alpabets.add(obj2);
        
        for (Y alpabet : alpabets) {
            alpabet.b();
        }
    }
}