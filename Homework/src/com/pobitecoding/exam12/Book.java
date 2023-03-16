package com.pobitecoding.exam12;

public class Book extends TangibleAsset {
    

    private String isbn;
    
    public Book(String isbn, int price, String color) {
        super(isbn, price, color);
    }

    public String getIsbn() {
        return isbn;
    }
}
