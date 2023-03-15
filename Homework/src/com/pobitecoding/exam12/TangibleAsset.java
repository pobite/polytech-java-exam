package com.pobitecoding.exam12;

public abstract class TangibleAsset extends Asset implements Thing{
    
    private double weight;
    
    @Override
    public double getWeight() {
        return weight;
    }
    
    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
}