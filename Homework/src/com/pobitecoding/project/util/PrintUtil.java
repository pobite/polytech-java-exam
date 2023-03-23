package com.pobitecoding.project.util;

public abstract class PrintUtil {
    
    /**
     * 첫 번째 출력문
     * 
     * 1. 회원관리
     * 2. 도서관리
     * 3. 종료
     */
    public static void firstMenu() {
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
    public static void secondMenu() {
        
        System.out.println("\n============================\r\n"
                + "0. 뒤로\r\n"
                + "1. 회원조회\r\n"
                + "2. 회원등록\r\n"
                + "3. 회원수정\r\n"
                + "4. 회원삭제\r\n"
                + "5. 삭제취소\r\n"
                + "============================\n");
    }
    
}
