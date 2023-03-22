package com.pobitecoding.exam.exam06;

/**
 * java.lang.Thread 클래스를 조사하여, 프로그램을 3초간 멈추게 하는 프로그램을 완성하시오.
 * throws Exception 에 대해서는 나중에 배우니 일단 무시하시오.
 * 
 * @author pobite
 *
 */
public class Exam6_1 {
    
    public static void main(String[] args) throws Exception {
        System.out.println("3초간 기다림!");
        
        // 3초간 기다림
        Thread.sleep(3000);
        System.out.println("끝");
    }
}
