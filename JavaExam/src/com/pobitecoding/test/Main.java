package com.pobitecoding.test;



public class Main {

  public static void main(String[] args) {

    int a = 10;
    double d = 3; // int -> double
    String s = "베스트 " + d; // double -> String
    String x = "베스트 " + true;
    System.out.println(s);
    System.out.println(x);

    int c = (int) 3.2;
    int f = (int) 3.2;

    System.out.println(5.0 / 2.0);

    System.out.println(Math.max(10, 20));

    // 5 ~ 10
    int rand = new java.util.Random().nextInt(6) + 5;
    System.out.println("랜덤한 수 " + rand);

    // -5 ~ 5
    int rand2 = new java.util.Random().nextInt(11) - 5;
    System.out.println("랜덤한 수 " + rand2);
    
    
    // input data using Scanner
    System.out.print("이름을 입력해 주세요: ");
    String name = new java.util.Scanner(System.in).nextLine();
    
    System.out.print("당신의 나이를 입력해주세요: ");
    int age = new java.util.Scanner(System.in).nextInt();
    
    System.out.println("반갑습니다. " + age + "살의 " + name + "씨");
  }
}
