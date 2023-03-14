package com.pobitecoding.game;

public class Wizard {
    private String name;
    private int hp;
    
    public void heal(Hero hero) {
        hero.hp += 10;
        System.out.println(hero.name + "의 HP를 10회복했다!");
    }
}
