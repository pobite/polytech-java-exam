package com.pobitecoding.test;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class Main {

  public static void main(String[] args) throws IOException {
      
      String msg = "Hello World";
      Reader reader = new StringReader(msg);

      
      
      FileOutputStream fos = new FileOutputStream("save.txt", true);
      fos.write(65);
      fos.write(66);
      fos.flush();
      fos.close();
      
//      System.out.println(fileRead("dat.txt"));
  }
  
  public static String fileRead(String fileName) throws IOException {
      String result = "";
      FileReader fr = new FileReader(fileName);
      
      int ch = fr.read();
      while (ch != -1) {
//          System.out.print((char) ch);
          result += (char) ch;
          ch = fr.read();
      }
      fr.close();
      return result;
  }
  
  
  public static void fileWriteCode() throws IOException {
      // 열고
      FileWriter fw = new FileWriter("dat.txt", true);  // true: 이어쓰기
      // 내용작성
      fw.write("Hello World\n");
      // 쓰고
      fw.flush();
      // 닫고
      fw.close();
  }
}