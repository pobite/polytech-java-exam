package com.pobitecoding.thread;

public class Counter {
    int num = 0;
    
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                    // 이 객체의 동시 접근을 막겠다
                    synchronized (counter) {
                        counter.num += 1; 
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println(counter.num);
    }
}