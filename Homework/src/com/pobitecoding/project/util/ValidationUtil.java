package com.pobitecoding.project.util;

public abstract class ValidationUtil {
    
    /**
     * 숫자의 범위를 판단합니다
     * 
     * @param input 고객이 입력한 정수값
     * @param start 시작 기준 정수값
     * @param end 종료 기준 정수값
     * @return 유효하지 않는 숫자면 true, 유효한 숫자면 false
     */
    public static boolean isInCorrectNum(int input, int start, int end) {
        if (start > input || input > end) {
            System.out.println("잘못된 입력");
            return true;
        }
        return false;
    }
}
