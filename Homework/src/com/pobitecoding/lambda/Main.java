package com.pobitecoding.lambda;

public class Main {
    
    public static boolean isOdd(int n) {
        return n % 2 == 1;
    }
    
    public static String addNamePrefix(boolean male, String name) {
        if (male == true) {
            return "Mr." + name;
        }
        return "Ms." + name;
    }
    
    public static void main(String[] args) {
        
        Utils isOdd = ::isOdd;
        
    }
}
