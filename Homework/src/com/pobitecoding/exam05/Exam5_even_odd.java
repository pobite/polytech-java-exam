package com.pobitecoding.exam05;

import java.util.Scanner;

public class Exam5_even_odd {
    
    public static String solution(int n, int m) {
        int result = n + m;
        return (result % 2 != 0) ? "YES" : "NO";
    }
  
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        
        System.out.println(solution(n, m));
    }
}