package com.pobitecoding.test;

public class Word2 {
    private String letters;

    public Word2(String letters) {
        this.letters = letters;
    }

    // 내코드
//    public boolean isVowel(int i) {
//        return "aeiou".contains(..letters.substring(i, i + 1).toLowerCase());
//    }
    
    // 최고의 코드
    public boolean isVowel(int i) {
        return "aeiouAEIOU".contains(letters.substring(i, i + 1));
    }
}