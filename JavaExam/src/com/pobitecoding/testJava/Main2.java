package com.pobitecoding.testJava;

import java.util.function.IntBinaryOperator;

public class Main2 {
    
    interface MyFunction {
        int call(int a, int b);
    }
    
    public static int add(int x, int y) {
        return x + y;
    }
    
    public static int plus(int a, int b) {
        return a + b;
    }
    
    public static void main(String[] args) {
        
        // 기존에 있던 걸 사용
        IntBinaryOperator addFunction = Main2::add;
        int result = addFunction.applyAsInt(10, 5);
        System.out.println(result);
        
        // 인터페이스에 함수를 만들어 저장
        MyFunction plus = Main2::add;
        MyFunction plus2 = Main2::add;
        
        // 람다식
        // 함수가 있으면 이름 때고 뒤에꺼 붙이고 인풋, 아웃풋 적기
        // 함수가 바로 만들어져서 익명 클래스처럼, 익명 함수라고 볼 수 있음
        // 그때그때 필요한 걸 만들 수 있음
        MyFunction addFunction2 = (int a, int b) -> {
            return a + b;
        };
        
        
        // 장점: 곱하기 필요하면 곱하기 만들어서 써야 하는데
        // 람다식은 함수 만들지 않고 바로 사용 가능
        
        MyFunction gophagi = (int a, int b) -> {
            return a * b;
        };
        
        result = plus.call(10, 20);     // 30
        result = gophagi.call(10, 20);  // 200
    }
}