package com.pobitecoding.game;

import java.util.Objects;

public class Hero {
    
    /*
     * member variables
     */
    private String name;
    private int hp;

    
    public Hero() {
//        System.out.println("Hero 생성자");
    }
    

    
    
    /*
     * getter/setter
     */
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getHp() {
        return hp;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public void run() {
        System.out.println("달린다");
    }
    
    public void attack(Kinoko kinoko) {
        System.out.println(kinoko + "을 공격한다");
    }

    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, name);  // 두 개가 들어가면 똑같은 값이 나옴
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Hero other = (Hero) obj;
        return hp == other.hp && Objects.equals(name, other.name);
    }
}