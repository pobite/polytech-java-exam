package com.pobitecoding.project.util;

public abstract class BookUtil {
    
    /**
     * 첫 번째 출력문
     * 1. 회원관리
     * 2. 도서관리
     * 3. 종료
     */
    public static void printFirstMenu() {
        System.out.println("\n============================\r\n"
                + "1. 회원관리\r\n"
                + "2. 도서관리\r\n"
                + "3. 종료\r\n"
                + "============================\n");
    }
    
    /**
     * 두 번째 출력문
     * 0: 뒤로
     * 1. 회원조회
     * 2. 회원등록
     * 3. 회원수정
     * 4. 회원삭제
     * 5. 삭제취소
     */
    public static void printSecondMenu() {
        
        System.out.println("\n============================\r\n"
                + "0. 뒤로\r\n"
                + "1. 회원조회\r\n"
                + "2. 회원등록\r\n"
                + "3. 회원수정\r\n"
                + "4. 회원삭제\r\n"
                + "5. 삭제취소\r\n"
                + "============================\n");
    }
    
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