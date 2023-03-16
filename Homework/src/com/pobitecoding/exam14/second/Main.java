package com.pobitecoding.exam14.second;

public class Main {
    
    
    public static void main(String[] args) {
        
        // 1. 계좌번호 4649, 잔액 1592원 Account 인스턴스를 변수 a 에 생성하고  
        // System.out.println(a); 를 실행하면, 화면에 1592원 (계좌번호=4649)) 라고 표시
        Account a = new Account("4649", 1592);
        System.out.println(a);
        
        // 2.계좌번호가 같으면 값이 같은 것으로 판단할 것. 
        // 단, “  4649” 처럼 계좌번호의 앞에 공백이 있으면, 공백을 무시하고 비교할 것 (“4649”와 “  4649 ”는 같은 것으로 본다)
        // (힌트 : java.lang.String 클래스의 trim() 메소드를 이용)
        System.out.println(new Account("7777", 1592).equals(new Account(" 7777", 1592)));
    }
}
