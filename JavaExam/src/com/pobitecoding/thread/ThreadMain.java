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
    
    public static void main(String[] args) {
        
        System.out.println("키 입력");
        Scanner scanner = new Scanner(System.in);
        
        
        // 스레드 2개 있음
        // 기본 Main에서 동작하는 스레드
        new Thread(() -> {
            System.out.println("ggg");
        }).start();
        
        scanner.nextLine();
    }
}
