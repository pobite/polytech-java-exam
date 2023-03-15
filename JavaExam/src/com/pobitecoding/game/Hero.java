package com.pobitecoding.game;

public class Hero {
    
    /*
     * member variables
     */
    private String name;
    private int hp;

    
    public Hero() {
        System.out.println("Hero 생성자");
    }
    
    
    /*
     * getter/setter
     */
    
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
        System.out.println("달린다");
    }
    
    public void attack(Kinoko kinoko) {
        System.out.println(kinoko + "을 공격한다");
    }
    
}