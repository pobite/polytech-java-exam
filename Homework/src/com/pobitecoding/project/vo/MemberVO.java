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

    public MemberVO() {
        
    }
    
    public MemberVO(int id, String name, int gender, int age, String address, String number,
            String birthDate, String joinDate) {
        super.setId(id);
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.number = number;
        this.birthDate = birthDate;
        this.joinDate = joinDate;
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

    @Override
    public String toString() {
        return "ID: " + super.getId() + ", 성함: " + name + ", 나이:" + age + ", 성별:" + gender
                    + ", 주소:" + address + ", 번호:" + number + ", 생년월일:" 
                    + birthDate + ", 가입날짜:" + joinDate;
    }
}