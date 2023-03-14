package com.pobitecoding.game;

public class Wand {
    private String name;
    private double power;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null이 아니어야 함");
        }
        if (name.length() <= 3) {
            throw new IllegalArgumentException("이름이 너무 짧음");
        }
        
        this.name = name;
    }
    
    public double getPower() {
        return power;
    }
    
    public void setPower(double power) {
        if (0.5 > power || power > 100.0) {
            throw new IllegalArgumentException("지팡이의 마력이 0.5보다 작거나 100.0보다 크면 안 됨");
        }
        this.power = power;
    }
}
