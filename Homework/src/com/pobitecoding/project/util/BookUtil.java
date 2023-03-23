package com.pobitecoding.project.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.pobitecoding.project.controller.main.MainController;
import com.pobitecoding.project.sort.BookAuthorAscComparator;
import com.pobitecoding.project.sort.BookEndDateAscComparator;
import com.pobitecoding.project.sort.BookPublicationDateAscComparator;
import com.pobitecoding.project.sort.BookTitleAscComparator;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.MemberVO;

public abstract class BookUtil {
    
    /**
     * 도서 조회
     * 모든 도서를 조회합니다.
     */
    public static void search() {
        List<BookVO> bookList = MainController.bookService.readAll();
        
        if (bookList.size() != 0) {
            
            System.out.println("정렬 기준을 선택하세요:");
            int sortType = MainController.scan.nextInt();
            
            List<String> types = Arrays.asList("1. 마감일", "2. 출간일", "3. 도서명", "4. 저자", "5. 출판사");
            for (String type : types) {
                System.out.println(type);
            }
            
            System.out.println("변경할 타입을 선택하세요:");
            int type = MainController.scan.nextInt();
            MainController.scan.nextLine();
            
            switch (type) {
                case 1 :
                    bookList.sort(new BookEndDateAscComparator());
                    System.out.println("마감일 기준으로 정렬되었습니다");
                    break;
                case 2 :
                    bookList.sort(new BookPublicationDateAscComparator());
                    System.out.println("출간일 기준으로 정렬되었습니다");
                    break;
                case 3 :
                    bookList.sort(new BookTitleAscComparator());
                    System.out.println("도서명 기준으로 정렬되었습니다");
                    break;
                case 4 :
                    bookList.sort(new BookAuthorAscComparator());
                    System.out.println("저자명 기준으로 정렬되었습니다");
                    break;
                default :
                    System.out.println("잘못된 입력을 정렬되지 않았습니다");
                    break;
            }
            
            for (BookVO book : bookList) {
                System.out.println(book.toString());
            }
        }
        else {
            System.out.println("등록된 도서가 없습니다.");
        }
    }
    
    /**
     * 도서 등록
     * 도서 정보를 입력받아 등록합니다.
     * 
     * Input: title, author, publisher
     */
    public static void join() {
        System.out.println("도서명을 입력하세요:");
        String title = MainController.scan.nextLine();
        
        System.out.println("저자명을 입력하세요:");
        String author = MainController.scan.nextLine();
        
        System.out.println("출판사를 입력하세요:");
        String publisher = MainController.scan.nextLine();
        
        System.out.println("출판일을 입력하세요:");
        System.out.println("ex. yyyy/mm/dd");
        String publicationDate = MainController.scan.nextLine();
        
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String nowString = format.format(now);
        System.out.println(nowString);
        
        BookVO vo = new BookVO();
        vo.setTitle(title);
        vo.setAuthor(author);
        vo.setPublisher(publisher);
        vo.setRegistrationDate(nowString);
        vo.setPublicationDate(publicationDate);
        
        if (MainController.bookService.create(vo)) {
            System.out.println(title + "책이 등록되었습니다.");
        }
    }
    
    /**
     * 도서 수정
     * id를 기준으로 한 권의 도서를 수정합니다. 
     */
    public static void edit() {
        System.out.println("수정할 id를 입력하세요:");
        int id = MainController.scan.nextInt();
        MainController.scan.nextLine();

        BookVO vo = MainController.bookService.read(id);
        
        /**
         * 도서가 존재하지 않는 경우
         */
        if (vo == null) {
            System.out.println("도서가 존재하지 않습니다.");
        }
        
        /**
         * 도서가 존재하는 경우
         */
        else {
            
            boolean isSuccess = false;
            
            List<String> types = Arrays.asList("1. 도서명", "2. 저자", "3. 출판사", "4. 대출 여부");
            
            for (String type : types) {
                System.out.println(type);
            }
            
            System.out.println("변경할 타입을 선택하세요:");
            int type = MainController.scan.nextInt();
            MainController.scan.nextLine();
            
            switch (type) {
                case 1 :
                    System.out.println("변경할 도서명 입력하세요:");
                    String title = MainController.scan.nextLine();
                    vo.setTitle(title);
                    isSuccess = true;
                    break;
                case 2 :
                    System.out.println("변경할 저자명을 입력하세요:");
                    String author = MainController.scan.nextLine();
                    MainController.scan.nextLine();
                    vo.setAuthor(author);
                    isSuccess = true;
                    break;
                case 3 :
                    System.out.println("변경할 출판사명을 입력하세요:");
                    String publisher = MainController.scan.nextLine();
                    vo.setPublisher(publisher);
                    isSuccess = true;
                    break;
                case 4 :
                    boolean isPossible = false;
                    isPossible = vo.getBookLoan().isPossibleBorrow();
                    
                    if (isPossible) {
                        System.out.println(vo.getTitle() + "는 \"대출 가능\" 상태입니다.");
                    }
                    else {
                        System.out.println(vo.getTitle() + "는 \"대출 불가능\" 상태입니다.");
                    }
                    
                    System.out.println("대출 여부를 변경하시려면 \"Y\"를 입력해주세요");
                    String answer = MainController.scan.nextLine();
                    
                    if (answer.equalsIgnoreCase("Y")) {
                        vo.getBookLoan().setPossibleBorrow(!isPossible); 
                    }
                    else {
                        System.out.println("변경을 취소합니다");
                    }
                default :
                    System.out.println("잘못된 입력");
                    break;
            }
            if (isSuccess) {
                System.out.println("처리되었습니다.");
            }
        }
    }
    /**
     * 도서 대출 여부 조회
     * 모든 도서의 대출 여부를 조회합니다.
     */
    public static void loan() {
        
        List<BookVO> bookList = MainController.bookService.readAll();
        
        if (bookList.size() != 0) {
            for (BookVO book : bookList) {
                if (book.getBookLoan().isPossibleBorrow()) {
                    System.out.println("ID: " + book.getId() + ", " + book.getTitle() + "의 책이 \"대출 가능\"합니다");
                }
                else {
                    System.out.println("ID: " + book.getId() + ", " + book.getTitle() + "의 책이 \"대출 불가능\"합니다");
                }
            }
        }
        else {
            System.out.println("등록된 도서가 없습니다.");
        }
    }
    
    /**
     * 도서 삭제
     * id를 기준으로 한 권의 도서를 삭제합니다.
     */
    public static void delete() {
        
        System.out.println("삭제할 도서의 id를 입력하세요:");
        int id = MainController.scan.nextInt();
        MainController.scan.nextLine();

        boolean isSuccess = false;
        isSuccess = MainController.bookService.delete(id);

        if (isSuccess) {
            System.out.println("도서가 삭제되었습니다.");
        }
        else {
            System.out.println("도서가 존재하지 않습니다.");
        }   
    }
    
    /**
     * 도서삭제 취소
     * 이전 도서삭제 명령을 취소합니다.
     */
    public static void deleteRollback() {
        if (MainController.bookService.create(MainController.prviousBook)) {
            System.out.println(MainController.prviousBook.getTitle() + " 책이 복구되었습니다.");
        }
    }
}