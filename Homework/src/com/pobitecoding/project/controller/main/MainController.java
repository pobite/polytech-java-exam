package com.pobitecoding.project.controller.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import com.pobitecoding.project.controller.book.BookController;
import com.pobitecoding.project.controller.customer.CustomerController;
import com.pobitecoding.project.dao.book.BookCsvDAOImpl;
import com.pobitecoding.project.dao.book.BookDAOImpl;
import com.pobitecoding.project.dao.book.BookDbmsDAOImpl;
import com.pobitecoding.project.dao.member.MemberCsvDAOImpl;
import com.pobitecoding.project.dao.member.MemberDAOImpl;
import com.pobitecoding.project.dao.member.MemberDbmsDAOImpl;
import com.pobitecoding.project.loan.LoanCsvDAOImpl;
import com.pobitecoding.project.loan.LoanDAOImpl;
import com.pobitecoding.project.loan.LoanDbmsDAOImpl;
import com.pobitecoding.project.service.book.BookService;
import com.pobitecoding.project.service.book.BookServiceImpl;
import com.pobitecoding.project.service.loan.LoanService;
import com.pobitecoding.project.service.loan.LoanServiceImpl;
import com.pobitecoding.project.service.member.MemberService;
import com.pobitecoding.project.service.member.MemberServiceImpl;
import com.pobitecoding.project.util.PrintUtil;
import com.pobitecoding.project.util.ValidationUtil;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.MemberVO;

public class MainController {
    
    public static Scanner scan = new Scanner(System.in);
    public static MemberService memberService;
    public static BookService bookService;
    public static LoanService loanService;
    public static MemberVO prviousMember = new MemberVO();
    public static BookVO prviousBook = new BookVO();
    public static Connection conn = null;
    
    public static void main(String[] args) {
        
        CustomerController customerCon = new CustomerController();
        BookController bookCon = new BookController();
        
        
        /**
         * 모드를 선택합니다.
         * 1. 테스터 모드 (메모리상에서 동작합니다)
         * 2. CSV 버전 (CSV상에서 동작합니다)
         * 3. DBMS 버전 (DBMS상에서 동작합니다)
         */
        
        PrintUtil.modeMenu();
        
        int mode = scan.nextInt();
        scan.nextLine();    // Enter를 무시
        //if (ValidationUtil.isInCorrectNum(mode, 1, 3)) continue;
        
        if (mode == 1) {
            memberService = new MemberServiceImpl(new MemberDAOImpl());
            bookService = new BookServiceImpl(new BookDAOImpl());
            loanService = new LoanServiceImpl(new LoanDAOImpl());
        }
        else if (mode == 2) {
            memberService = new MemberServiceImpl(new MemberCsvDAOImpl());
            bookService = new BookServiceImpl(new BookCsvDAOImpl());
            loanService = new LoanServiceImpl(new LoanCsvDAOImpl());
        }
        else if (mode == 3) {
            
            // 데이터베이스에 연결합니다.
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String url = "jdbc:oracle:thin:@192.168.119.119:1521/dink";
                String user = "scott";
                String passwd = "tiger";
                conn = DriverManager.getConnection(url, user, passwd);
                System.out.println(conn);
            
            } catch (ClassNotFoundException e) {
                // 드라이버 로드 중 예외가 발생한 경우 처리합니다.
                e.printStackTrace();
            } catch (SQLException e) {
                // 데이터베이스 연결 및 쿼리 실행 중 예외가 발생한 경우 처리합니다.
                e.printStackTrace();
            }
            
            memberService = new MemberServiceImpl(new MemberDbmsDAOImpl());
            bookService = new BookServiceImpl(new BookDbmsDAOImpl());
            loanService = new LoanServiceImpl(new LoanDbmsDAOImpl());
        }
        
        
        /**
         * 프로그램 시작
         */
        
        boolean isExit = false;
        while(!isExit) {
            
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
                System.out.println("종료를 누르셨습니다.");
                System.out.println("이용해주셔서 감사합니다.");
                isExit = false;
            }
            
            // 연결, 쿼리 실행, 결과 처리에 사용된 오브젝트들을 종료합니다.
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}