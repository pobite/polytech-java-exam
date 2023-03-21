package com.pobitecoding.testJava;

public class Array {
    public static void main(String[] args) {
        
        int[] scores = { 20, 30, 40, 50, 80 };
        
        int sum = scores[0] + scores[1] + scores[2]
                + scores[3] + scores[4];
        int avg = sum / scores.length;
        System.out.println("총점 " + sum);
        System.out.println("평균 " + avg);
    }
}
