package com.pobitecoding.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        // 제네릭 사용 안 하는 경우
        // 제니릭으로 타입 지정 안하면 암묵적으로 Object를 받는다고 함
        List list = new ArrayList<>();
        
        list.add(1);
        list.add("홍길동");
        list.add(null);
        list.add(1);
        
        Object object = (int) (list.get(0));
        System.out.println((String) list.get(0) + 10);
    }
}