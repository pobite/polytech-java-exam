package com.pobitecoding.extra.thread;

public class Main {

    public static void main(String[] args) {
        new CountUpThread().start();
        new CountUpThread().start();
        new CountUpThread().start();
    }
}