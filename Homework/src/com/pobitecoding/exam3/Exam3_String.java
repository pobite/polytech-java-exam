package com.pobitecoding.exam3;

import java.util.Scanner;

/**
 * 문자열 결합
 * 
 * @author pobite
 *
 */
public class Exam3_String {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String sentence = "";
        for (int i = 0; i < num; i++) {
            if (i == 0) {
                sentence = scan.next();
                continue;
            }
            sentence = sentence + "," + scan.next();
        }
        System.out.println("Hello " + sentence + ".");
    }
}