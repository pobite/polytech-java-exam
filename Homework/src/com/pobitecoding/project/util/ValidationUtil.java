package com.pobitecoding.project.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public abstract class ValidationUtil {
    
    /**
     * 숫자의 범위를 판단합니다
     * 
     * @param input 고객이 입력한 정수값
     * @param start 시작 기준 정수값
     * @param end 종료 기준 정수값
     * @return 유효하지 않는 숫자면 true, 유효한 숫자면 false
     */
    public static boolean isInCorrectNum(int input, int start, int end) {
        if (start > input || input > end) {
            System.out.println("잘못된 입력입니다");
            return true;
        }
        return false;
    }
    
    /**
     * 해당 문자열이 숫자로 구성되어 있는지 판단합니다
     * @param input String 타입의 문자열
     * @return
     */
    public static boolean isNotNum(String input) {
        if (Pattern.matches("^[0-9]*$", input)) {
            return false;
        }
        else {
            System.out.println("잘못된 입력입니다");
            return true;
        }
    }
    
    /**
     * 해당 문자열이 문자로 구성되어 있는지 확인합니다
     * 
     * @param input String 타입의 문자열
     * @return
     */
    public static boolean isNotText(String input) {
        if (Pattern.matches("^[a-zA-Z]*$ ", input)) {
            return false;
        }
        else {
            System.out.println("잘못된 입력입니다");
            return true;
        }
    }
    
    /**
     * 해당 날짜가 올바른 형태의 날짜인지 확인합니다
     * 포맷은 yyyy-MM-dd 인지 확인합니다
     * 
     * @param checkDate String 타입의 날짜 문자
     * @return
     */
    public static boolean isNotDate(String checkDate) {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        
        format.setLenient(false);
        try {
            format.parse(checkDate);
            return false;
        } catch (ParseException e) {
            System.out.println("잘못된 입력입니다");
            return true;
        }
    }
}