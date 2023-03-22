package com.pobitecoding.exam.exam04;
/**
 * 다음 4개의 조건에 맞는 “숫자 맞추기 퀴즈" 프로그램을 작성 하시오.
 * 
 * @author pobite
 *
 */
public class Exam4_4 {
    
    public static void main(String[] args) {
        
        // 1. 3개짜리 int형 배열 numbers를 준비하시오. 
        // 이 때 초기화는 각각 3, 4, 9 로 합니다.
        int[] numbers = {3, 4, 9};
        
        // 2. 화면에 “1자리의 숫자를 입력 해 주세요" 라고 표시합니다
        System.out.println("1자리의 숫자를 입력 해 주세요");
        
        // 3. int input = new java.util.Scanner(System.in).nextInt();
        // 를 대입합니다.
        int input = new java.util.Scanner(System.in).nextInt();
        
        // 4. input값이 3, 4, 9 중 하나와 같다면 “정답!” 이라고 표시합니다.
        if (input == 3 || input == 4 || input == 9) {
            System.out.println("정답!");
        }
    }
}