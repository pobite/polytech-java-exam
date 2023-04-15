package com.pobitecoding.project.util;

public abstract class PrintUtil {
    
    /**
     * 메인 출력문
     * 
     * 1. 테스트 모드 (저장 기능 off)
     * 2. 도서관 관리 프로그램
     */
    public static void modeMenu() {
        System.out.println("\n============================\r\n"
                + "1. 테스트 모드\r\n"
                + "2. 도서관 관리 프로그램\r\n"
                + "============================\n");
    }
    
    
    /**
     * 첫 번째 출력문
     * 
     * 1. 회원관리
     * 2. 도서관리
     * 3. 종료
     */
    public static void mainMenu() {
        System.out.println("\n============================\r\n"
                + "1. 회원관리\r\n"
                + "2. 도서관리\r\n"
                + "3. 종료\r\n"
                + "============================\n");
    }
    
    /**
     * 두 번째 출력문
     * 
     * 0: 뒤로
     * 1. 회원조회
     * 2. 회원등록
     * 3. 회원수정
     * 4. 회원삭제
     * 5. 삭제취소
     */
    public static void memberMenu() {
        
        System.out.println("\n============================\r\n"
                + "0. 뒤로\r\n"
                + "1. 회원조회\r\n"
                + "2. 회원등록\r\n"
                + "3. 회원수정\r\n"
                + "4. 회원삭제\r\n"
                + "5. 삭제취소\r\n"
                + "============================\n");
    }
    
    public static void bookMenu() {
        
        System.out.println("\n============================\r\n"
                + "0. 뒤로\r\n"
                + "1. 도서조회\r\n"
                + "2. 도서등록\r\n"
                + "3. 도서수정\r\n"
                + "4. 도서대출\r\n"
                + "5. 도서삭제\r\n"
                + "6. 삭제취소\r\n"
                + "============================\n");
    }
    
    
}
