package com.pobitecoding.game;

public class Hero {
    // field variable -- 많이 사용
    // global variable
    // member variable - 많이 사용
    // property
    String name;
    int hp;
    
    Sword sword;
    
    static int MONEY;
    
    // 기본 생성자
    // primary constructor
    Hero() {
        this.name = "noname";
        this.hp = 100;
        sword = new Sword();
        
    }
    
    Hero(int hp) {
        this.name = "noname";
        this.hp = hp;
    }
    
    Hero(String name) {
        this.name = name;
        this.hp = 100;
    }
    
    Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }
    
    void attack() {
        System.out.println(this.name + "는 공격했다!");
        System.out.println("적에게 5포인트의 데미지를 주었다!");
    }
    void run() {}
    void sit(int sec) {}
    void slip() {}
    void sleep() {
        hp = 100;
        System.out.println(this.name + "는 잠을 자고 회복했다");
    }  
    
    static void setRandomMoney() {
        Hero.MONEY = (int) (Math.random() * 1000);
    }
    
}