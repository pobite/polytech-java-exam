package com.pobitecoding.project.vo;

import java.util.Date;

public class MemberVO extends AbstractVO{
    
    private String name;
    private int gender;
    private int age;
    private String address;
    private String number;
    private String birthDate;
    private String joinDate;
    private BookBorrow bookBorrow;
    
    public MemberVO() {
        bookBorrow = new BookBorrow();
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public BookBorrow getBookLoan() {
        return bookBorrow;
    }

    public void setBookLoan(BookBorrow bookLoan) {
        this.bookBorrow = bookLoan;
    }

    @Override
    public String toString() {
        return "나이순으로 정렬되었습니다.\n" + "ID: " + super.getId() + ", 성함: " + name + ", 나이:" + age + ", 성별:" + gender
                    + ", 주소:" + address + ", 번호:" + number + ", 생년월일:" 
                    + birthDate + ", 가입날짜:" + joinDate;
    }
}