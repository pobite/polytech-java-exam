package com.pobitecoding.project.controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.pobitecoding.project.service.book.BookService;
import com.pobitecoding.project.service.book.BookServiceImpl;
import com.pobitecoding.project.service.member.MemberService;
import com.pobitecoding.project.service.member.MemberServiceImpl;
import com.pobitecoding.project.util.BookUtil;
import com.pobitecoding.project.util.CheckUtil;
import com.pobitecoding.project.util.CustomerUtil;
import com.pobitecoding.project.util.PrintUtil;
import com.pobitecoding.project.vo.MemberVO;

public class BookController {
    
    public static Scanner scan = new Scanner(System.in);
    public static MemberService memberService = new MemberServiceImpl();
    public static BookService bookService = new BookServiceImpl();
    public static MemberVO prviousMember = new MemberVO();
    
    public static void main(String[] args) {
        
        while(true) {
                        
            PrintUtil.firstMenu();
            
            /**
             * 입력 받아 menu에 저장
             */
            int menu = scan.nextInt();
            scan.nextLine();    // Enter를 무시
            
            if (CheckUtil.isInCorrectNumFirst(menu)) continue;
            
            /**
             * 1. 회원관리
             */
            if (menu == 1) {
                
                PrintUtil.secondMenu();
                
                /**
                 * 입력 받아 menu에 저장 후
                 * 범위 안에 있는 숫자인지 확인
                 */
                menu = scan.nextInt();
                scan.nextLine();    // Enter를 무시
                if (CheckUtil.isInCorrectNumSecond(menu)) continue;
                
                /**
                 * 0-0. 뒤로
                 */
                if (menu == 0) {
                    continue;
                }
                /**
                 * 0-1. 회원조회
                 */
                else if (menu == 1) {
                    CustomerUtil.customerSearch();
                }
                /**
                 * 0-2. 회원등록
                 */
                else if (menu == 2) {
                    CustomerUtil.customerJoin();
                }
                /**
                 * 0-3. 회원수정
                 */
                else if (menu == 3) {
                    CustomerUtil.customerEdit();
                }
                /**
                 * 0-4. 회원삭제
                 */
                else if (menu == 4) {
                    CustomerUtil.customerDelete();
                }
                /**
                 * 0-5. 삭제취소
                 */
                else if (menu == 5) {
                    CustomerUtil.deleteRollback();
                }
            }
            /**
             * 2. 도서관리
             */
            else if (menu == 3) {
                
            }
            /**
             * 3. 종료
             */
            else if (menu == 4) {
                System.out.println("종료합니다.");
                break;
            }
        }
    }
}