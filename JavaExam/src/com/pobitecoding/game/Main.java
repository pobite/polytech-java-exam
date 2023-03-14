package com.pobitecoding.game;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        
        Wand wand = new Wand();
        wand.setName(null);
        wand.setName("지팡이");
        wand.setName("나무꼬치");
        wand.setPower(0.4);
        wand.setPower(101.0);
        wand.setPower(50.0);

        
        Wizard wizard = new Wizard();
        wizard.setName(null);
        wizard.setName("론");
        wizard.setName("해르미온느");
        wizard.setWand(null);
        wizard.setMp(-1);
        wizard.setMp(10);
        wizard.setHp(-2);
    }
}