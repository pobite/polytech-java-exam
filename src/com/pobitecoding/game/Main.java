package com.pobitecoding.game;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        
        Hero superMan = new Hero("슈퍼맨", 100);
        Hero batMan = new Hero("배트맨", 100);
        
        
//        System.out.println("안녕하십니까. pobite의 게임 월드에 오신 것을 환영합니다.\n");
//        
//        // 8-1
//        Cleric cleric = new Cleric();
//        cleric.name = "magician";
//        System.out.println("클래릭 직업의 '" + cleric.name + "'이 생성되었습니다.\n");
//        
//        // 8-3
//        cleric.selfAid();
//        System.out.println("'셀프 에이드' 스킬을 사용했습니다.");
//        System.out.println("현재 HP가 " + cleric.HP + "으로 회복했습니다.");
//        System.out.println("현재 MP는 " + cleric.MP + "입니다.\n");
//        
//        // 8-4
//        Random rand = new Random();
//        int amountMP = cleric.pray(rand.nextInt(6));    // Because selfAid() uses MP 5
//        if (amountMP == -1) {
//            System.out.println("Fail: 최대 MP보다 회복량이 많아 MP를 회복하지 못 했습니다.");
//        }
//        else {
//            System.out.println(cleric.name + "의 MP가 " + amountMP +"만큼 회복됐습니다.");
//            System.out.println("현재 MP는 " + cleric.MP + "입니다.");
//        }
    }
}