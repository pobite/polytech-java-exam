package com.pobitecoding.project.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.pobitecoding.exam.exam09.Main;
import com.pobitecoding.project.controller.main.MainController;
import com.pobitecoding.project.sort.BookAuthorAscComparator;
import com.pobitecoding.project.sort.BookEndDateDescComparator;
import com.pobitecoding.project.sort.BookPublicationDateDescComparator;
import com.pobitecoding.project.sort.BookPublisherAscComparator;
import com.pobitecoding.project.sort.BookTitleAscComparator;
import com.pobitecoding.project.vo.BookVO;
import com.pobitecoding.project.vo.LoanVO;
import com.pobitecoding.project.vo.MemberVO;

public abstract class BookUtil {
    
    /**
     * 도서 조회
     * 모든 도서를 조회합니다.
     */
    public static int search() {
        List<BookVO> bookList = MainController.bookService.readAll();
        
        if (bookList.size() != 0) {
            
            System.out.println("조회 기준을 선택해주세요:");
            List<String> types = Arrays.asList("1. 출간일", "2. 도서명", "3. 저자", "4. 출판사");
            for (String type : types) {
                System.out.println(type);
            }
            
            int menu = MainController.scan.nextInt();
            if (ValidationUtil.isInCorrectNum(menu, 1, 4)) return 0;
            
            switch (menu) {
                case 1 :
                    bookList.sort(new BookPublicationDateDescComparator());
                    System.out.println("출간일 기준으로 정렬되었습니다");
                    break;
                case 2 :
                    bookList.sort(new BookTitleAscComparator());
                    System.out.println("도서명 기준으로 정렬되었습니다");
                    break;
                case 3 :
                    bookList.sort(new BookAuthorAscComparator());
                    System.out.println("저자명 기준으로 정렬되었습니다");
                    break;
                case 4 :
                    bookList.sort(new BookPublisherAscComparator());
                    System.out.println("출판사명 기준으로 정렬되었습니다");
                    break;
                default :
                    System.out.println("잘못된 입력으로 정렬되지 않았습니다");
                    break;
            }
            
            for (BookVO book : bookList) {
                System.out.println(book.toString());
            }
        }
        else {
            System.out.println("등록된 도서가 없습니다.");
        }
        return 0;
    }
    
    /**
     * 도서 등록
     * 도서 정보를 입력받아 등록합니다.
     * 
     * Input: title, author, publisher
     */
    public static int join() {
        System.out.println("도서명을 입력하세요:");
        String title = MainController.scan.nextLine();
        
        System.out.println("저자명을 입력하세요:");
        String author = MainController.scan.nextLine();
        
        System.out.println("출판사를 입력하세요:");
        String publisher = MainController.scan.nextLine();
        
        System.out.println("출판일을 입력하세요:");
        System.out.println("ex. yyyy/mm/dd");
        String publicationDate = MainController.scan.nextLine();
        if (ValidationUtil.isNotDate(publicationDate)) return 0;

        BookVO vo = new BookVO();
        vo.setTitle(title);
        vo.setAuthor(author);
        vo.setPublisher(publisher);
        vo.setPublicationDate(publicationDate);
        
        if (MainController.bookService.create(vo)) {
            System.out.println("\"" + title + "\" 책이 등록되었습니다.");
        }
        return 0;
    }
    
    /**
     * 도서 수정
     * id를 기준으로 한 권의 도서를 수정합니다. 
     */
    public static int edit() {
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
            
            List<String> types = Arrays.asList("1. 도서명", "2. 저자", "3. 출판사");
            for (String type : types) {
                System.out.println(type);
            }
            
            System.out.println("변경할 타입을 선택하세요:");
            int type = MainController.scan.nextInt();
            MainController.scan.nextLine();
            
            if (ValidationUtil.isInCorrectNum(type, 1, 3)) return 0;

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
                default :
                    System.out.println("잘못된 입력");
                    break;
            }
            if (isSuccess) {
                boolean result = MainController.bookService.update(vo);
                if (result) {
                    System.out.println("DBMS에서 도서 정보가 수정되었습니다.");
                } else {
                    System.out.println("도서 정보가 수정되었습니다.");
                }
            }
        }
        return 0;
    }
    /**
     * 도서 대출
     * 도서의 대출관 관련된 작업을 수행합니다.
     */
    public static int loan() {
        
        List<String> types = Arrays.asList("1. 대출가능조회", "2. 대출진행조회 ", "3. 대출신청",
                                           "4. 대출연장", "5. 대출반납");
        for (String type : types) {
            System.out.println(type);
        }
        
        System.out.println("타입을 선택하세요:");
        int type = MainController.scan.nextInt();
        MainController.scan.nextLine();
        
        if (ValidationUtil.isInCorrectNum(type, 1, 5)) return 0;
            
        switch (type) {
            /**
             * 1. 대출 가능 조회
             */
            case 1 :
                List<BookVO> bookList = MainController.bookService.readBorrow();
                
                if (bookList.size() != 0) {
                    bookList.sort(new BookPublicationDateDescComparator());
                    System.out.println("대출 가능한 도서의 목록입니다.(최근 출간순)");
                    for (BookVO book : bookList) {
                        System.out.println(book.toString());
                    }
                }
                else {
                    System.out.println("현재 대출 가능한 도서가 없습니다.");
                }
                break;
            /**
             * 2. 대출 진행 조회
             */
            case 2 :
                List<LoanVO> loanList = MainController.loanService.readAll();
                
                if (loanList.size() != 0) {
                    loanList.sort(new BookEndDateDescComparator());
                    System.out.println("현재 대출 중인 도서입니다.(대출 마감일순)");
                    for (LoanVO loan : loanList) {
                        System.out.println(loan.toString());
                    }
                }
                else {
                    System.out.println("현재 대출 중인 도서가 없습니다.");
                }
                break;
            /**
             * 3. 대출신청
             */
            case 3 :
                System.out.println("대출할 도서의 id를 입력하세요:");
                int bookId = MainController.scan.nextInt();
                MainController.scan.nextLine();
                
                BookVO bookVO = MainController.bookService.read(bookId);
                
                /**
                 * 도서가 존재하지 않는 경우
                 */
                if (bookVO == null) {
                    System.out.println("도서가 존재하지 않습니다.");
                    break;
                }
                
                System.out.println("대출할 회원의 id를 입력하세요:");
                int memberId = MainController.scan.nextInt();
                MainController.scan.nextLine();
                
                /**
                 * 회원이 존재하지 않는 경우
                 */
                MemberVO memberVO = MainController.memberService.read(memberId);
                if (memberVO == null) {
                    System.out.println("회원이 존재하지 않습니다.");
                    break;
                }
                if (bookVO.isPossibleBorrow()) {
                    LoanVO loan = new LoanVO(memberId, bookId);
                    if (MainController.loanService.create(loan)) {
                        bookVO.setPossibleBorrow(false);
                        System.out.println("대출이 등록되었습니다.");
                    }
                    else {
                        System.out.println("대출시 실패하였습니다.");
                    }
                    
                }
                else {
                    System.out.println("해당 도서가 대출 중임으로, 대출이 불가합니다.");
                }
                break;
            /**
             * 4. 대출연장    
             */
            case 4 :
                System.out.println("대출 연장할 도서의 id를 입력하세요:");
                bookId = MainController.scan.nextInt();
                MainController.scan.nextLine();
                
                LoanVO loan = MainController.loanService.readMem(bookId);
                
                /**
                 * 도서가 존재하지 않는 경우
                 */
                if (loan == null) {
                    System.out.println("도서가 존재하지 않습니다.");
                }
                
                /**
                 * 도서가 존재하는 경우
                 */
                else {
                    if (loan.isPossibleExtend()) {
                        System.out.println("대출 여부를 변경하시려면 \"Y\"를 입력해주세요");
                        String answer = MainController.scan.nextLine();
                        
                        if (answer.equalsIgnoreCase("Y")) {
                            loan.setPossibleExtend(false);
                            String dateString = loan.getEndDate();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                            LocalDate date = LocalDate.parse(dateString, formatter);
                            LocalDate extendedDate = date.plusWeeks(1);
                            String extendedDateString = extendedDate.format(formatter);
                            loan.setEndDate(extendedDateString);
                            System.out.println("2주의 도서 대출이 완료되었습니다.");
                        }
                        else {
                            System.out.println("변경을 선택하지 않았습니다.");
                        }
                    }
                    else {
                        System.out.println("이미 대출 연장을 사용하여 대출 연장이 불가합니다.");
                    }
                }
                break;
            /**
             * 5. 대출반납
             */
            case 5 :
                System.out.println("대출 반납할 도서의 id를 입력하세요:");
                bookId = MainController.scan.nextInt();
                MainController.scan.nextLine();
                
                loan = MainController.loanService.readBook(bookId);
                
                if (loan == null) {
                    System.out.println("해당 도서는 대출이 진행 중이지 않습니다.");
                    break;
                }
                
               
                System.out.println("대출 반납을 진행하려면 \"Y\"를 입력해주세요");
                String answer = MainController.scan.nextLine();
                
                if (answer.equalsIgnoreCase("Y")) {
                    BookVO book = MainController.bookService.read(bookId);
                    book.setPossibleBorrow(true);
                    
                    MainController.loanService.deleteByBookId(bookId);
                    System.out.println("반납이 완료되었습니다");
                }
                else {
                    System.out.println("반납을 진행하지 않았습니다");
                }
        }
        return 0;
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
        
        if (MainController.prviousBook.getId() != 0) {
            MainController.bookService.create(MainController.prviousBook);
            System.out.println(MainController.prviousBook.getTitle() + " 책이 복구되었습니다.");
        }
        else {
            System.out.println("최근에 삭제한 도서가 존재하지 않습니다");
        }
    }
}