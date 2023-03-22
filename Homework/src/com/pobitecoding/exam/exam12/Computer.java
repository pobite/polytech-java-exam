package com.pobitecoding.exam.exam12;

public class Computer extends TangibleAsset {
    
    private String makerName;
    
    public Computer(String makerName, int price, String color) {
        super(makerName, price, color);
    }

    public String getMakerName() {
        return makerName;
    }
}