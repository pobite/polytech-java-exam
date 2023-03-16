package com.pobitecoding.exam13;

public class Main {
    
    public static void main(String[] args) {
        // 1. X obj = new A(); 로 A인스턴스를 생성한 후,
        // 변수 obj에서 호출할 수 있는 메소드를 a(), b(), c() 중에 골라보시오
        
        X obj = new A();
        
        // 답: a()

        
        // 2. Y y1 = new A();
        // Y y2 = new B(); 로 A와 B의 인스턴스를 생성한 후 
        // y1.a();
        // y2.a(); 를 실행했을 때에 화면에 표시되는 내용을 말하시오.
        
        Y y1 = new A();
        Y y2 = new B();
        
        y1.a();
        y2.a();
        
        // 답
        // Aa
        // Ba
    }
}