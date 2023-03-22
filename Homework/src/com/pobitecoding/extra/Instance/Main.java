package com.pobitecoding.Instance;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        List<Book> library = new ArrayList<>();
        
        Calendar calendar = Calendar.getInstance();
        
        // 2014.12.20
        calendar.set(2014, 12 - 1, 20);
        Date date1 = calendar.getTime();
        
        // 2023.03.02
        calendar.set(2023, 3 - 1, 2);
        Date date2 = calendar.getTime();
        
        // 2022.04.28
        calendar.set(2022, 4 - 1, 28);
        Date date3 = calendar.getTime();
                
        library.add(new Book("행복이란 무엇인가", date1, "좋은책입니다."));
        library.add(new Book("세이노의 가르침", date2, "가르침이 좋습니다."));
        library.add(new Book("당신은 결국 무엇이든 해내는 사람", date3, "인생책입니다."));
        
        
        // 1. 제목과 출간일이 같으면 같은 책으로 판단한다. 
        // 또한 HashSet 등의 컬렉션에 넣어도 동일 객체로 판단한다.
        
        Book bookTest1 = new Book("자바의 정석", date1, "좋음");
        Book bookTest2 = new Book("행복이란 무엇인가", date1, "보통");
        System.out.println(bookTest1.equals(bookTest2));
        
        Book bookTest3 = new Book("행복이란 무엇인가", date1, "좋음");
        Book bookTest4 = new Book("행복이란 무엇인가", date1, "보통");
        System.out.println(bookTest3.equals(bookTest4));
        
        
        // 2. Book 인스턴스를 담고 있는 컬렉션에 대해 Collections.sort() 를 사용하면
        // 출간일이 오래된 순서대로 정렬된다.
        
        System.out.println(library);
        
        // 정렬 후
        Collections.sort(library);
        System.out.println(library);
        
        // 3. clone() 메서드를 호출하면 복제된다.
        Book bookClone = bookTest1.clone();
        System.out.println(bookClone);
        System.out.println(bookClone);
    }
}