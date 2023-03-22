package com.pobitecoding.extra.lambda;

public class Main {
    
    public static void main(String[] args) {
        
        // 인터페이스에 함수 대입
        Func1 call = Utils::isOdd;
        Func2 call2 = Utils::addNamePrefix;
        
        // 람다에 함수 대입
        call = n -> n % 2 == 1;
        call2 = (gender, name) -> {
            if (gender == true) {
                return "Mr." + name;
            }
            return "Ms." + name;
        };
    }
}