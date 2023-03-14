package com.pobitecoding.game;

public class Wizard {
    private String name;
    private int hp;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getHp(int hp) {
        return hp;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public void heal(Hero hero) {
        int basePoint = 10;    // 기본회복 포인트
        int recovPoint = (int) (basePoint * this.wand.power);   // 지팡이에 의한 증폭
        hero.setHp(hero.getHp() + recovPoint);                  // 용사의 HP를 회복
    }
}
