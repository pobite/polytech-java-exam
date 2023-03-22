package com.pobitecoding.exam.exam06;

import java.util.Random;
import java.util.Scanner;

/**
 * 조용한 곳 찾기
 * 
 * @author pobite
 *
 */
public class Exam6_FindRoad {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        // 정수 a, b, R 입력 받기
        int x = scan.nextInt(); // x 좌표
        int y = scan.nextInt(); // y 좌표
        int R = scan.nextInt(); // 공사 현장의 소음 크기

        
        int N = scan.nextInt(); // 나무 그늘의 수
        String[] sounds = new String[N]; // String 배열 생성
        
        // Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2))
        for (int i = 0; i < N; i++) {
            int x_i = scan.nextInt();
            int y_i = scan.nextInt();

            double position = Math.sqrt((x_i - x) * (x_i - x) + (y_i - y) * (y_i - y));

            if (position < R) {
                sounds[i] = "noisy";
            } else {
                sounds[i] = "silent";
            }
        }
        
        // 출력
        for (int i = 0; i < sounds.length; i++) {
            System.out.println(sounds[i]);
        }
    }
}
