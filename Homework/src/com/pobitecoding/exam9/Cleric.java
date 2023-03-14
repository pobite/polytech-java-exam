package com.pobitecoding.exam9;

import java.util.Random;
/**
 * 연습문제 9-2
 * 
 * @author pobite
 *
 */

public class Cleric {

    String name;
    
    static final int HP_MAX = 50;
    static final int MP_MAX = 10;
    
    int hp = HP_MAX;
    int mp = MP_MAX;

    // A) 이 클래스는 new Cleric(“아서스", 40, 5) 와 같이,
    // 이름, HP, MP 를 지정하여 인스턴스화 할 수 있다
    Cleric(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }
    
    // B) 이 클래스는 new Cleric(“아서스", 35) 와 같이, 
    // 이름과 HP만으로 지정하여 인스턴스화 할 수 있다.
    // 이 때, MP는 최대 MP와 같은 값이 초기화 된다

    Cleric(String name, int hp) {
        this(name, hp, MP_MAX);
    }
    
    // C) 이 클래스는 new Cleric(“아서스") 와 같이 이름만을 지정하여 인스턴스화 할 수 있다.
    // 이 때, HP 와 MP 는 최대 HP와 최대 MP로 초기화 된다

    Cleric(String name) {
        this(name, HP_MAX, MP_MAX);
    }
    
    void selfAid() {
        this.mp -= 5;
        this.hp = HP_MAX;
    }
    
    int pray(int sec) {
        
        Random rand = new Random();
        int amountMP = sec + rand.nextInt(3);   // Recovery amount
        
        if (amountMP + this.mp <= MP_MAX) { // Check over than Max MP
            this.mp += amountMP;
            return amountMP;
        }
        else {
            return -1;  //  Irrecoverable
        }
    }
}