package com.pobitecoding.project.util;

public abstract class CheckUtil {
    
    /**
     * 첫 번째 출력문의 숫자가 올바르지 않는지 확인
     * 
     * @param input 고객의 입력값
     * @return 1보다 작거나, 3보다 크면 true, 아니면 false
     */
    public static boolean isInCorrectNumFirst(int input) {
        if (1 > input || input > 3) {
            System.out.println("잘못된 입력");
            return true;
        }
        return false;
    }
    
    /**
     * 두 번째 출력문의 숫자가 올바르지 않는지 확인
     * 
     * @param input 고객의 입력값
     * @return 0보다 작거나, 5보다 크면 true, 아니면 false
     */
    public static boolean isInCorrectNumSecond(int input) {
        if (0 > input || input > 5) {
            System.out.println("잘못된 입력");
            return true;
        }
        return false;
    }
}
