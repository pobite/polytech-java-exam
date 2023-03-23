package com.pobitecoding.project.vo;

import java.util.Date;

public class MemberVO extends AbstractVO{
    
    private String name;
    private String gender;
    private String address;
    private String number;
    private Date birthDate;
    private Date joinDate;
    private BookBorrow bookLoan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public void setNumber() {
        this.number = number;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public BookBorrow getBookLoan() {
        return bookLoan;
    }

    public void setBookLoan(BookBorrow bookLoan) {
        this.bookLoan = bookLoan;
    }
}