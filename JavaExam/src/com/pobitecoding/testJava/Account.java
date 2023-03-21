package com.pobitecoding.testJava;

public class Account {
    
    public static void main(String[] args) {
        
        //getter, setter 빼고 public 메소드 테스트
        
        System.out.println("=== 테스트 시작 ===");
        Account account = new Account("홍길동", 30000);
        System.out.println(account);
        
        Account account2 = new Account("한석봉", 0);
        account.transfer(account2, Integer.MAX_VALUE + 1);  // MAX 값 넘는 경우
        
        // 같으면 성공, 다르면 실패
        if (account2.getBalance() != 2147483648L) {
            System.out.println("getBalance() 값 다름 " + account2.getBalance());
        }
        
        System.out.println("=== 테스트 끝 ===");
    }
    
    
    private String owner;
    private int balance;
    
    public Account(String owner, int balance) {
        this.owner = owner ;
        this.balance = balance;
    }
    
    // 1원 ~ 1억까지
    // 테스트할 때
    // 1, 1억
    // 양 끝값에서 하나씩 빼기
    // 0, 1억 1원 : 실패
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
