package com.pobitecoding.game;

public class SuperHero extends Hero {
    
    private boolean flying;
    
    public SuperHero() {
        super();
        System.out.println("SuperHero 생성자");
    }
    
    public void fly() {
        flying = true;
    }
    
    public void land() {
        flying = false;
    }
    
    // 오버 라이딩
    @Override
    public void run() {
        System.out.println("퇴각했다.");
    }
    
    @Override
    public void attack(Kinoko kinoko) {
        
        System.out.println("준비운동");
        
        super.attack(kinoko); // 중간에 넣어도 됨, 넣을지 말지 선택
        
        if (flying) {
            System.out.println("추가 공격");
        }
    }
}