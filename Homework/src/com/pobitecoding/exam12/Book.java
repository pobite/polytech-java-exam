package com.pobitecoding.exam12;

public class Book extends TangibleAsset {
    
    private String name;
    private int price;
    private String color;
    private String isbn;
    
    public Book(String name, int price, String color, String isbn) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getIsbn() {
        return isbn;
    }
}
