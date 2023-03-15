package com.pobitecoding.exam09;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        
        // A
        Cleric cleric1 = new Cleric("아서스", 40, 5);
        System.out.println("첫 번째 캐릭터 이름은 " + cleric1.name + " HP는 " 
                            + cleric1.hp + " MP는 " + cleric1.mp + "입니다.");
        
        // B
        Cleric cleric2 = new Cleric("아서스", 35);
        System.out.println("두 번째 캐릭터 이름은 " + cleric2.name + " HP는 " 
                + cleric2.hp + " MP는 " + cleric2.mp + "입니다.");
        
        // C
        Cleric cleric3 = new Cleric("아서스");
        System.out.println("세 번째 캐릭터 이름은 " + cleric3.name + " HP는 " 
                + cleric3.hp + " MP는 " + cleric3.mp + "입니다.");
    }
}