package com.pobitecoding.game;

public class Weapon extends Item {
    
    // 기본 생성자 생성
    public Weapon() {
        super("noname");
    }
    
    public Weapon(String name) {
        super(name);
    }

    public Weapon(String name, int price) {
        super(name, price);
    }
}
