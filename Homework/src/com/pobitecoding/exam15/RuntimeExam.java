package com.pobitecoding.exam15;

public class RuntimeExam {
    
    public static void main(String[] args) {
        String s = null;
        
        try {
            s.length(); 
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException 예외를 catch 하였습니다");
            System.out.println("---- stack trace (여기부터) ----");
            e.printStackTrace();
            System.out.println("---- stack trace (여기까지) ----");
        }
    }
}