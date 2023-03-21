package com.pobitecoding.testJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {
    
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        
        // for each가 컨슈머를 받음
        // 리턴이 void여야 함
        // void가 리턴인 것을 수행하면 됨
        
        // 안에 들어온 것을 하나씩 받아서 print
        nums.stream().forEach((num) -> {
            System.out.println(num);
        });
        
        // 줄이기
        nums.stream().forEach((num) -> System.out.println(num));
        
        // 더 줄이기
        nums.stream().forEach(System.out::println);
        
        // 필터
        // 필터는 if문 대신 쓴다
        // 해당 조건으로 거름
        // 모든 데이터가 줄 서서 이동
        
        nums.stream()
            .filter((num) -> num % 2 == 0)              // 짝수
            .forEach(System.out::println);

        // 같은 방법
        for (int i = 0; i < nums.size(); i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        
        // 추가 작업이 있을 경우
        nums.stream()
        .filter((num) -> num % 2 == 0)              // 짝수
        .forEach((num) -> System.out.println(num + 1));
        
        // 필터 - 거르기
        // forEach - 무지성 뺑뺑이
        
        // map - 변환
        nums.stream()
            .filter((num) -> num % 2 == 0)                   // 거르기   2, 4, 6
            .map((num) -> num + "번")                         // 변환    "2번", "4번", "6번"
            .forEach((num) -> System.out.println(num + 1));  // 무지성 뺑뺑이
        
        // -> 리스트의 타입이 계속 변환한다
        // 이 세 개는 리턴 타입이 스트림이다
        // Stream은 void
        // 그래서 스트림은 마지막에만 올 수 있음
        // 점찍고 점찍으면서 반복하는게 메서드 체이닝
        
        
        // 기존에 있는 리스트에서 원하는 애만 뽑아서 리스트만 다시 반환
        
        List<String> names = new ArrayList<>();
        names.add("박경덕");
        names.add("박준하");
        names.add("이동학");
        names.add("박태현");
        
//        List<String> parks = getParkList(names);
//        System.out.println("parks");
        // 출력 - parks

        
        // 람다식과 스트림 활용
        
        System.out.println(names.stream().filter(name -> name.startsWith("박"))
                                         .collect(Collectors.toList()));
        // [박경덕, 박준하, 박태현]
    }
    
    // 기존 로직
    public static List<String> getParkList(List<String> names) {
        // filter가 스트림을 리턴, 리스트로 바꿔야 함
        return names.stream().filter(name -> name.startsWith("박"))
                             .collect(Collectors.toList());
        
//        List<String> results = new ArrayList<>();
//        
//        for (String name: names) {
//            if (name.startsWith("박")) {
//                results.add(name);
//            }
//        }
//        return results;
    }
    
    
    
    
}