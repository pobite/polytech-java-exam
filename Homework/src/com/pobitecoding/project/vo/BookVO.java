package com.pobitecoding.project.vo;

public class BookVO extends AbstractVO {
    
    private String title;
    private String author;
    private String publisher;
    private String registrationDate;
    private BookBorrow bookBorrow;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public BookBorrow getBookLoan() {
        return bookBorrow;
    }
    public void setBookLoan(BookBorrow bookBorrow) {
        this.bookBorrow = bookBorrow;
    }
    public String getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    @Override
    public String toString() {
        return "ID: " + super.getId() + ", 제목: " + title + ", 저자:" + author + ", 출판사:" + publisher
                + ", 등록일: " + registrationDate;
    }
}