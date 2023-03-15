package com.pobitecoding.game;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        
        PoisonKinoko poisonKinoko = new PoisonKinoko('A');
        Hero hero = new Hero();
        hero.setHp(50);
        
        poisonKinoko.attack(hero);
    }
}