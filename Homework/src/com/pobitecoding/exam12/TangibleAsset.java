package com.pobitecoding.exam12;

public abstract class TangibleAsset extends Asset implements Thing{
    
    private String color;
    private double weight;
        
    public TangibleAsset(String name, int price, String color) {
        super(name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    
    // weight는 수정할 수 있어서 생성자에 넣는 거 선택
    @Override
    public double getWeight() {
        return weight;
    }
    
    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
}