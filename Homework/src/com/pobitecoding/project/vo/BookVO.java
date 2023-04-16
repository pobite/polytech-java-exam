package com.pobitecoding.project.vo;

public class BookVO extends AbstractVO {
    
    private String title;
    private String author;
    private String publisher;
    private String publicationDate;
    private boolean isPossibleBorrow;
    
    public BookVO() {
        isPossibleBorrow = true;
    }
    
    public BookVO(int id, String title, String author, String publisher, String publicationDate,
            boolean isPossibleBorrow) {
        super.setId(id);;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.isPossibleBorrow = isPossibleBorrow;
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
    
    public boolean isPossibleBorrow() {
        return isPossibleBorrow;
    }
    public void setPossibleBorrow(boolean isPossibleBorrow) {
        this.isPossibleBorrow = isPossibleBorrow;
    }
    @Override
    public String toString() {
        return "ID: " + super.getId() + ", 제목: " + title + ", 저자:" + author + ", 출판사:" + publisher
                + ", 출간일: " + publicationDate + ", 대출가능: " + isPossibleBorrow;
    }
}