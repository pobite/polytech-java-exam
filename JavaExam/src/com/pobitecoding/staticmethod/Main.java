package com.pobitecoding.staticmethod;

public class Main {
    
    public static void main(String[] args) {
        Hero.setRandomMoney();
        System.out.println(Hero.MONEY);
        
        Hero hero = new Hero();
        System.out.println(hero.MONEY);
    }
}
