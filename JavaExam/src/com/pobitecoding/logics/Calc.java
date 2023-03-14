package com.pobitecoding.logics;

import java.util.Arrays;

public class Calc {
    
    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        int total = CalcLogic.add(a, b);
        int delta = CalcLogic.minus(a, b);
        
        int[] heights = {170, 240, 300, 15, 320};
        Arrays.sort(heights);   // API 활용
        
        for (int height : heights) {
            System.out.println(height);
        }
    }
}
