package com.pobitecoding.project.controller.book;

import com.pobitecoding.project.controller.main.MainController;
import com.pobitecoding.project.util.BookUtil;
import com.pobitecoding.project.util.PrintUtil;
import com.pobitecoding.project.util.ValidationUtil;

public class BookController {
    
    
    public int start() {
        PrintUtil.bookMenu();
        
        /**
         * 입력 받아 menu에 저장 후
         * 범위 안에 있는 숫자인지 확인
         */
        int menu = MainController.scan.nextInt();
        MainController.scan.nextLine();    // Enter를 무시
        if (ValidationUtil.isInCorrectNum(menu, 0, 6)) return 0;
        
        /**
         * 0-0. 뒤로
         */
        if (menu == 0) {
            return 0;
        }
        /**
         * 0-1. 도서조회
         */
        else if (menu == 1) {
            BookUtil.search();
        }
        /**
         * 0-2. 도서등록
         */
        else if (menu == 2) {
            BookUtil.join();
        }
        /**
         * 0-3. 도서수정
         */
        else if (menu == 3) {
            BookUtil.edit();
        }
        /**
         * 0-4. 도서삭제
         */
        else if (menu == 4) {
            BookUtil.delete();
        }
        /**
         * 0-5. 삭제취소
         */
        else if (menu == 5) {
            BookUtil.deleteRollback();
        }
        return 0;
    }
}
