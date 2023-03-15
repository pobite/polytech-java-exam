package com.pobitecoding.game;

public abstract class Character {
    private String name;
    private int hp;
    
    public Character(String name) {
        this.name = name;
        hp = 100;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getHp() {
        return hp;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public void run() {
        System.out.println(name + "은 도망쳤다");
        
    }
    
    // 추상 메소드
    // 미구현 할 거면 abstract 키워드 붙이기
    // 바디 없어야 함.
    // 추상 메소드를 가지려면 추상 클래스여야 함
    public abstract void attack(Kinoko kinoko);
    
}