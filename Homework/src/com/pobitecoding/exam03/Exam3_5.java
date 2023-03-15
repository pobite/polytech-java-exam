package com.pobitecoding.exam03;

import java.util.Scanner;

/**
 * switch 문을 이용하여 다음 조건을 만족하는 프로그램을 작성하시오
 * 
 * @author pobite
 *
 */
public class Exam3_5 {

    public static void main(String[] args) {

        // 1. 화면에 “[메뉴] 1:검색 2:등록 3:삭제 4:변경 >” 을 표시한다
        System.out.println("[메뉴] 1:검색 2:등록 3:삭제 4:변경 >");

        // 2. 키보드로 숫자를 입력하고, 변수 selected 에 대입한다.
        Scanner scan = new Scanner(System.in);
        int selected = scan.nextInt();

        // 3. 만약 변수 selected 가 1 이면 “검색합니다", 2이면 “등록합니다", 3이면 “삭제합니다", 4이면 “변경합니다"를 표시한다
        // 4. selected 가 1 부터 4 사이의 값이 아니라면 아무것도 하지 않는다

        switch (selected) {
            case 1:
                System.out.println("검색합니다");
                break;
            case 2:
                System.out.println("등록합니다");
                break;
            case 3:
                System.out.println("삭제합니다");
                break;
            case 4:
                System.out.println("변경합니다");
                break;
            default:
        }
    }
}
