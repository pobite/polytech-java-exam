package com.pobitecoding.testJava;

public class Word2 {
    private String letters;

    public Word2(String letters) {
        this.letters = letters;
    }

    // 내코드
//    public boolean isVowel(int i) {
//        return "aeiou".contains(..letters.substring(i, i + 1).toLowerCase());
//    }
    
    // 모음 최고의 코드
    public boolean isVowel(int i) {
        return "aeiouAEIOU".contains(letters.substring(i, i + 1));
    }
    
//    public boolean isConsonant(int i) {
//        return !"aeiouAEIOU".contains(letters.substring(i, i + 1));
//    }
    
    // 자음 최고의 코드
    public boolean isConsonant(int i) {
        return !isVowel(i);
    }
    
    public boolean isConsonant2(int i) {
        return letters.substring(i, i + 1).matches("^[aeiouAEIOU]");
    }
}