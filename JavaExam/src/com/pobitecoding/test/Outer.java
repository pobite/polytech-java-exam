package com.pobitecoding.test;

class Outer {
    
    // 참조가 순환
    // 가비지 컬렉터가 돌면서 메모리 안 쓰는 거 지우는데
    // 서로 참조해서 지워지지 않음
    // 메모리에 계속 묶여 있음
    // 전체가 다 묶인다
    int i = 0;
    
    void something() {
        new Inner().something();
    }
    
    class Inner {
        void something() {
            i = 10; // Outer의 i 참조
        }
    }
}
