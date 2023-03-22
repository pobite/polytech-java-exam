package com.pobitecoding.exam.exam15;

public class IntegerExam {
    
    public static void main(String[] args) {
        
        // Integer.parseInt() 메소드를 사용하여,
        // 문자열 “Three” 의 변환결과를 int형 변수 i 에 대입하는 코드를 작성하시오. 
        // int i = Integer.parseInt("Three");
        
        try {
            int i = Integer.parseInt("Three");
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
