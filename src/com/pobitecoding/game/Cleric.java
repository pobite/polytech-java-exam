package com.pobitecoding.game;

import java.util.Random;
/**
 * 연습문제 8-4
 * 
 * @author pobite
 *
 */

public class Cleric {

    String name;
    
    final int HP_MAX = 50;
    final int MP_MAX = 10;
    
    int HP = HP_MAX;
    int MP = MP_MAX;

    void selfAid() {
        this.MP -= 5;
        this.HP = HP_MAX;
    }
    
    int pray(int sec) {
        
        Random rand = new Random();
        int amountMP = sec + rand.nextInt(3);   // Recovery amount
        
        if (amountMP + this.MP <= MP_MAX) { // Check over than Max MP
            this.MP += amountMP;
            return amountMP;
        }
        else {
            return -1;  //  Irrecoverable
        }
    }
}