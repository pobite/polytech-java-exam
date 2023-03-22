package com.pobitecoding.testJava;

import java.util.ArrayList;
import java.util.List;

interface OnClickEvent {
    
    // 옵저버 패턴
    // onClick을 건드리면 
    // 오버라이드 한쪽에서 반응해서
    void onClick();
}

class Button {
    
    private OnClickEvent listener;
    
    // 버튼을 누르면 어떤 일을 할 건지 정하는 인터페이스
    public Button(OnClickEvent listener) {
        this.listener = listener;
    }

    void click() {
        listener.onClick();
        listener.onClick();
    }
   
    public static void main(String[] args) throws InterruptedException {
        
        // 콜백
        Button addButton = new Button(new OnClickEvent() {

            @Override
            public void onClick() {
                System.out.println("Click!!!!");
            }
        });
        
        Button button2 = new Button(new OnClickEvent() {

            @Override
            public void onClick() {
                System.out.println("클릭!!!!");
            }
        });
        
        List<Button> buttons = new ArrayList<>();
        buttons.add(addButton);
        buttons.add(button2);
        
        buttons.stream().forEach((button) -> button.click());
        
    }
}