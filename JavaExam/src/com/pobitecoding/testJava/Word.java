package com.pobitecoding.testJava;

public class Word {
    
    private String letters;
    
    public Word(String letters) {
        this.letters = letters;
    }
    
    public boolean isVowel(int i) {        
        if ("aeiou".contains(letters.substring(i, i + 1).toLowerCase())) {
            return true;
        }
        return false;
    }
}