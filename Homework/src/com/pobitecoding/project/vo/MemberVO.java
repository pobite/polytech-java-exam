package com.pobitecoding.project.vo;

public class MemberVO extends AbstractVO{
    
    private String name;
    private int gender;
    private String address;
    private String number;
    private String birthDate;
    private String joinDate;
    private BookBorrow bookLoan;

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
        return bookLoan;
    }

    public void setBookLoan(BookBorrow bookLoan) {
        this.bookLoan = bookLoan;
    }

    @Override
    public String toString() {
        return "User (name=" + name + ", id=" + super.getId() + ", gender=" + gender + ")";
    }
}