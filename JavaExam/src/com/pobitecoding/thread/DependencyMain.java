package com.pobitecoding.thread;

import java.util.LinkedList;
import java.util.List;

interface Counter2 {
    int count();
}

class UpCounter implements Counter2 {
    int count = 0;
    @Override
    public int count() {
        count++;
        return count;
    }
}


class DownCounter implements Counter2 {
    int count = 0;
    @Override
    public int count() {
        count--;
        return count;
    }
}

//DependencyMain와 DownCounter는 의존 관계 (의존하고 있음)

// 의존하지 못 하게 막는 방법
// 인터페이스를 사용하기
// 인터페이스의 다형성을 통해
// 인터페이스를 구현한 클래스들을 담을 수 있으면
// 특정클래스에 의존하지 않고 인터페이스에 의존하게 됨
// 특정 클래스를 직접 의존하는 걸 우회
// -> 인터페이스를 통해 의존이 끊어지게
// -> 직접적인 참조가 제거 됨

public class DependencyMain {
    
    final Counter2 counter;
    
    public DependencyMain(Counter2 counter) {
        this.counter = counter;
    }
    
    // 리스트 인터페이스를 통해 List를 구현한 모든 객체 담을 수 있음
    // 다형성
    public void sort(List<String> list) {
        
    }
    
    // 올릴지 내릴지 모르는 경우
    // Counter2를 통해 올리든 내리든 하게 하기
    public void count2(Counter2 counter) {
        counter.count();
    }
    
    public static void main(String[] args) {
        DependencyMain main = new DependencyMain(new DownCounter());
        // 넣고 싶은 카운터 객체 만들어 넣기
        // main.count2();
        
        LinkedList<String> list = new LinkedList<>();
        // 메소드에서 매개변수 타입이 List여서
        // 어떤 List 타입이든 가능!
        main.sort(list);
    }
}