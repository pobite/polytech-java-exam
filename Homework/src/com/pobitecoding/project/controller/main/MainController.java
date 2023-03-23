package com.pobitecoding.project.controller.main;

import java.util.Scanner;
import com.pobitecoding.project.controller.book.BookController;
import com.pobitecoding.project.controller.customer.CustomerController;
import com.pobitecoding.project.service.book.BookService;
import com.pobitecoding.project.service.book.BookServiceImpl;
import com.pobitecoding.project.service.member.MemberService;
import com.pobitecoding.project.service.member.MemberServiceImpl;
import com.pobitecoding.project.util.PrintUtil;
import com.pobitecoding.project.util.ValidationUtil;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.MemberVO;

public class MainController {
    
    public static Scanner scan = new Scanner(System.in);
    public static MemberService memberService = new MemberServiceImpl();
    public static BookService bookService = new BookServiceImpl();
    public static MemberVO prviousMember = new MemberVO();
    public static BookVO prviousBook = new BookVO();
    
    public static void main(String[] args) {
        
        CustomerController customerCon = new CustomerController();
        BookController bookCon = new BookController();
        
        while(true) {
                        
            PrintUtil.mainMenu();
            
            int menu = scan.nextInt();
            scan.nextLine();    // Enter를 무시
            
            if (ValidationUtil.isInCorrectNum(menu, 1, 3)) continue;
            /**
             * 1. 회원관리
             */
            if (menu == 1) {
                customerCon.Start();
            }
            /**
             * 2. 도서관리
             */
            else if (menu == 2) {
                bookCon.start();
            }
            /**
             * 3. 종료
             */
            else if (menu == 3) {
                System.out.println("종료합니다.");
                break;
            }
        }
    }
}