package com.pobitecoding.exam04;
/**
 * 각 라인에서 발생하는 예외의 이름을 답하시오
 * 
 * @author pobite
 *
 */

public class Exam4_3 {
    
    public static void main(String[] args) {
        int[] counts = null;
        float[] heights = {171,3f, 175,0f};
        // NullPointerException 발생
        System.out.println(counts[1]);
        // IndexOutOfBoundsException 발생
        System.out.println(heights[2]);
    }
}