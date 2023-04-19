package com.pobitecoding.project.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LoanVO extends AbstractVO{
    
    private int memberId;
    private int bookId;
    private boolean isPossibleBorrow;
    private boolean isPossibleExtend;
    private String startDate;
    private String endDate;
    
    public LoanVO() {
        super();
    }

    public LoanVO(int memberId, int bookId) {
        
        this.memberId = memberId;
        this.bookId = bookId;
        isPossibleBorrow = true;
        isPossibleExtend = true;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        
        LocalDate now = LocalDate.now();
        String nowString = now.format(formatter);
        
        LocalDate twoWeeksLater = now.plusWeeks(2);
        String twoWeeksLaterString = twoWeeksLater.format(formatter);
       
        this.startDate = nowString;
        this.endDate = twoWeeksLaterString;
        this.isPossibleBorrow = false;
    }
    
    
    
    public LoanVO(int id, int memberId, int bookId, boolean isPossibleBorrow, boolean isPossibleExtend,
            String startDate, String endDate) {
        super.setId(id);
        this.memberId = memberId;
        this.bookId = bookId;
        this.isPossibleBorrow = isPossibleBorrow;
        this.isPossibleExtend = isPossibleExtend;
        this.startDate = startDate;
        this.endDate = endDate;
    }



    public boolean isPossibleBorrow() {
        return isPossibleBorrow;
    }

    public void setPossibleBorrow(boolean isPossibleBorrow) {
        this.isPossibleBorrow = isPossibleBorrow;
    }

    public boolean isPossibleExtend() {
        return isPossibleExtend;
    }

    public void setPossibleExtend(boolean isPossibleExtend) {
        this.isPossibleExtend = isPossibleExtend;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "ID: " + super.getId() + ", 회원 ID: " + memberId + ", 책 ID " + bookId
                + ", 대출 시작일: " + startDate + ", 대출 마감일 " + endDate
                + ", 대출 연장 가능 여부 " + isPossibleExtend;
    }
}