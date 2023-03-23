package com.pobitecoding.project.util;

public abstract class CheckUtil {
    
    /**
     * 메인 페이지에 대한 입력 int 값이 올바르지 않는지 확인
     * 
     * @param input 고객의 입력값
     * @return 1보다 작거나, 3보다 크면 true, 아니면 false
     */
    public static boolean isInCorrectNumMain(int input) {
        if (1 > input || input > 3) {
            System.out.println("잘못된 입력");
            return true;
        }
        return false;
    }
    
    /**
     * 회원 페이지에 대한 입력 int 값이 올바르지 않는지 확인
     * 
     * @param input 고객의 입력값
     * @return 0보다 작거나, 5보다 크면 true, 아니면 false
     */
    public static boolean isInCorrectNumMember(int input) {
        if (0 > input || input > 5) {
            System.out.println("잘못된 입력");
            return true;
        }
        return false;
    }
    
    /**
     * 도서 페이지에 대한 입력 int 값이 올바르지 않는지 확인
     * 
     * @param input 고객의 입력값
     * @return 0보다 작거나, 6보다 크면 true, 아니면 false
     */
    public static boolean isInCorrectNumBook(int input) {
        if (0 > input || input > 6) {
            System.out.println("잘못된 입력");
            return true;
        }
        return false;
    }
}
