package com.pobitecoding.lambda;

public class Main {
    
    public static void main(String[] args) {
        
        Func1 call = Utils::isOdd;
        Func2 call2 = Utils::addNamePrefix;
    }
}