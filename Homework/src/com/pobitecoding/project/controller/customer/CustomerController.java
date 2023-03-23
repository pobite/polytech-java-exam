package com.pobitecoding.project.controller.customer;

import com.pobitecoding.project.controller.main.MainController;
import com.pobitecoding.project.util.CheckUtil;
import com.pobitecoding.project.util.CustomerUtil;
import com.pobitecoding.project.util.PrintUtil;

public class CustomerController {
    
    public int Start() {
        
        PrintUtil.memberMenu();
        
        /**
         * 입력 받아 menu에 저장 후
         * 범위 안에 있는 숫자인지 확인
         */
        int menu = MainController.scan.nextInt();
        MainController.scan.nextLine();    // Enter를 무시
        if (CheckUtil.isInCorrectNumMember(menu)) return 0;
        
        /**
         * 0-0. 뒤로
         */
        if (menu == 0) {
            return 0;
        }
        /**
         * 0-1. 회원조회
         */
        else if (menu == 1) {
            CustomerUtil.search();
        }
        /**
         * 0-2. 회원등록
         */
        else if (menu == 2) {
            CustomerUtil.join();
        }
        /**
         * 0-3. 회원수정
         */
        else if (menu == 3) {
            CustomerUtil.edit();
        }
        /**
         * 0-4. 회원삭제
         */
        else if (menu == 4) {
            CustomerUtil.delete();
        }
        /**
         * 0-5. 삭제취소
         */
        else if (menu == 5) {
            CustomerUtil.deleteRollback();
        }
        return 0;
    }
}
