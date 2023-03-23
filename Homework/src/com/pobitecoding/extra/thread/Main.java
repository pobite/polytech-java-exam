package com.pobitecoding.extra.thread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        Counter counter = new Counter();
        
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                counter.add(1);
                                counter.add(1);
                                counter.mul(1);
            }).start();
        }
        Thread.sleep(2000);
        System.out.println("The result is  " + counter.getCount());
    }
}