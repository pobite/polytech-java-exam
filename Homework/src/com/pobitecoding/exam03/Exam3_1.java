package com.pobitecoding.exam03;

/**
 * 다음 문장을 Java 조건식으로 기술하시오.
 * 
 * @author pobite
 *
 */
public class Exam3_1 {

    public static void main(String[] args) {

        // 1. 변수 weight 의 값이 60과 같다
        int weight = 63;
        if (weight == 60) {

        }

        // 2. 변수 age1 과 age2 의 합계를 2배 한 것이 60을 넘는다
        int age1 = 25;
        int age2 = 27;
        if ((age1 + age2) * 2 > 60) {
        }
        
        // 3. 변수 age 가 홀수다
        int age = 3;
        
        boolean isOdd = age % 2 == 1;  // 홀수
        boolean isEven = !isOdd;       // 좋은 방법
        // boolean isEven = age % 2 == 0;  // 짝수
        
        if (age % 2 != 0) {
        }

        // 4. 변수 name 에 저장된 문자열이 “스마트"와 같다
        String name = "smart";
        if (name.equals("스마트")) {

        }

    }
}