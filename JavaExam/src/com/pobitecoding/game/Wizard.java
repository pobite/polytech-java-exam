package com.pobitecoding.game;

public class Wizard {
    private int hp;
    private int mp;
    private String name;
    private Wand wand;
    
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
    
    public int getHp(int hp) {
        return hp;
    }
    
    public void setHp(int hp) {
        this.hp = (hp < 0) ? 0 : hp;
    }
    
    public int getMp(int mp) {
        return mp;
    }
    
    public void setMp(int mp) {
        if (mp < 0) {
            throw new IllegalArgumentException("mp가 0미만이 아니어야 함");
        }
        this.mp = mp;
    }
    
    public Wand getWand() {
        return wand;
    }
    
    public void setWand(Wand wand) {
        if (wand == null) {
            throw new IllegalArgumentException("wand가 null이 아니어야 함");
        }
        this.wand = wand;
    }
    
    public void heal(Hero hero) {
        int basePoint = 10;    // 기본회복 포인트
        int recovPoint = (int) (basePoint * this.wand.getPower());   // 지팡이에 의한 증폭
        hero.setHp(hero.getHp() + recovPoint);                  // 용사의 HP를 회복
    }
}
