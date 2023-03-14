package com.pobitecoding.exam6;
/**
 * 구구단을 작성하시오
 * @author pobite
 *
 */
public class Exam6_2 {

    public static void main(String[] args) {
        
        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf(j + " * " + i + " = %2d" + "\t", (i * j));
            }
            System.out.println("");
        }
    }
}
