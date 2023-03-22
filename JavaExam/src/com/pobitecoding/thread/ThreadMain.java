package com.pobitecoding.thread;

import java.util.Scanner;

// 인터페이스를 상속 받은 애를 구현
class PrintingThread extends Thread {
    
    // Thread가 run()을 오버라이드 한 상태
    // 다시 오버라이드
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

// 인터페이스를 구현하든
class PrintingThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }        
    }
}

public class ThreadMain {
    
    // 다양한 형태로 사용 가능!
    public static void main(String[] args) {
        
        System.out.println("키 입력");
        Scanner scanner = new Scanner(System.in);
        
//        new PrintingThread().start();

        // 익명 클래스
        // ctrl 1을 누르면 Convert to 람다식
        // 익명 클래스에서 커서 놓고 ctrl1로 편하게 변환 가능
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                
            }
        }).start();
        
        //람다식
        // 람다에서도 ctrl 1로 익명 클래스로 변환 가능
        new Thread(() -> {
            System.out.println("ggg");
        }).start();
        
        // -> ctrl 1로 상호 변환 가능
        
        // 인터페이스 타입을 만는 경우 옵션이 많아짐 
        scanner.nextLine();
    }
}
