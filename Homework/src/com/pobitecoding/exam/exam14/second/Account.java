package com.pobitecoding.exam.exam14.second;

import java.util.Objects;

public class Account {
    
    private String accountNumber;
    private int balance;
    
    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public int getBalance() {
        return balance;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        return Objects.equals(accountNumber.trim(), other.accountNumber.trim());
    }
    
    @Override
    public String toString() {
        return this.getBalance() + "원 (계좌번호=" + this.getAccountNumber() + "))";
    }
}
