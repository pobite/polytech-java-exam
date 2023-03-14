package com.pobitecoding.staticmethod;

public class Hero {
    String name;
    int hp;
    static int MONEY;
    Sword sword;
    
    static void setRandomMoney() {
        Hero.MONEY = (int) (Math.random() *1000);
    }
}
