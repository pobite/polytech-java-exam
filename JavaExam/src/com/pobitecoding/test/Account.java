package com.pobitecoding.test;

public class Account {
    
    public static void main(String[] args) {
        
        //getter, setter 빼고 public 메소드 테스트
        
        System.out.println("=== 테스트 시작 ===");
        Account account = new Account("홍길동", 30000);
        System.out.println(account);
        System.out.println("=== 테스트 끝 ===");
    }
    
    
    private String owner;
    private int balance;
    
    public Account(String owner, int balance) {
        this.owner = owner ;
        this.balance = balance;
    }
    
    public void transfer(Account dest, int amount) {
        dest.setBalance(dest.getBalance() + amount);
        balance -= amount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account [owner=" + owner + ", balance=" + balance + "]";
    }
}
