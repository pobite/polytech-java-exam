package com.pobitecoding.project.vo;

public class BookVO extends AbstractVO {
    
    private String title;
    private String author;
    private String publisher;
    private String publicationDate;
    private String registrationDate;
    private BookBorrow bookBorrow;
    
    public BookVO() {
        bookBorrow = new BookBorrow();
    }
    
    public String getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
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
    public BookBorrow getBookBorrow() {
        return bookBorrow;
    }
    public void setBooBorrow(BookBorrow bookBorrow) {
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
                + ", 출간일: " + publicationDate + ", 대출 여부: " + getBookBorrow().isPossibleBorrow();
    }
}