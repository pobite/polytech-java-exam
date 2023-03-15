package com.pobitecoding.exam06;

import java.util.Random;
import java.util.Scanner;

/**
 * 반지름이 1인 원 안에 다트를 던져서 원주율 구하기.
 * @author pobite
 *
 */

public class Exam6_4 {
    
    public static void main(String[] args) {
        
        // 1.던질 횟수를 입력해주세요 를 출력한다
        System.out.println("던질 횟수를 입력해주세요");
        
        // 2. 키보드로부터 long값을 변수 tries 에 입력 받는다
        Scanner scan = new Scanner(System.in);
        long tries = scan.nextLong();
        
        // 3. 정수형 hits 변수를 0으로 초기화 한다
        int hits = 0;
        
        // 4. 입력 받은 tries 의 수 만큼 for 문을 반복하며 아래 a, b 를 수행한다
        // a. 다트가 꽂히는 좌표 x, y 를 랜덤한 값으로 정하되 범위는 -1 ~ 1 사이의 실수(double) 로 한다
        // 힌트 : new Random().nextDouble() 는 0 ~ 1 사이의 실수를 랜덤하게 리턴 해 준다
        
        // b. 다트가 꽂힌 좌표가 원 안에 있을 경우 hits 를 증가연산자를 사용하여 1 증가 시킨다
        // 힌트 : 두 점 (x1, y1), (x2, y2) 의 거리는 
        // Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) 로 구할 수 있음
        
        Random rand = new Random();
        for (int i = 0; i < tries; i++) {
            double x = rand.nextDouble() * 2 - 1;
            double y = rand.nextDouble() * 2 - 1;
            
            if (Math.sqrt((x * x) + (y * y)) <= 1) {
                hits++;
            }
        }
        
        // 5. 반복이 끝나면 실수형 변수 piEstimate 를 선언과 동시에 PI 값을 계산하여 대입하여 초기화 한다
        // 힌트 : hits / tries 의 비율은 원의 면적 / 사각형의 면적과 같고
        // 이는 원주율(PI) / 4 와도 같다. 이 관계를 이용하여 PI를 구하면 됨
        // 식은 이겁니다 : piEstimate = 4 * hits / tries
        double piEstimate = 4 * hits / (double) tries;
        
        // 6. 마지막에 PI 값의 예상값 piEstimate 를 출력한다.
        System.out.println(piEstimate);
    }
}
