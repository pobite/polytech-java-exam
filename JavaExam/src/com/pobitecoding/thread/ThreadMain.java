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
        
//        System.out.println("키 입력");
//        Scanner scanner = new Scanner(System.in);
        
        // 현재 수행되는 스레드를 얻는 것
//        System.out.println("Thread : " + Thread.currentThread().getName());

        StringBuilder sb = new StringBuilder();
        
        new Thread(() -> {
            for (int i = 0; i < 3; i ++) {
                try {
                    Thread.sleep(50);
                    System.out.println("Thread : " + Thread.currentThread().getName() + " " + i);
                    sb.append(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
        // 복사본
        new Thread(() -> {
            for (int i = 0; i < 3; i ++) {
                try {
                    System.out.println("Thread : " + Thread.currentThread().getName() + " " + i);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
//        scanner.nextLine();
    }
}
