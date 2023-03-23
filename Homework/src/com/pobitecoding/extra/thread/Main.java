package com.pobitecoding.extra.thread;

public class Main {

    public class CountUpThread extends Thread {
        
        @Override
        public void run() {
            for (int i = 0; i <= 50; i++) {
                System.out.println(i);
            }
        }
    }
}