package com.pobitecoding.file;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class StreamCopy {
    
    public static void print(String fileName) {
        
        // try문에 작성하여 auto close 작동
        try (FileInputStream input = new FileInputStream(fileName)) {
            int readBuffer = 0;
            while ((readBuffer = input.read()) != -1) {
                System.out.print((char) readBuffer);
            }
            System.out.println("\n" + fileName +"의 파일 읽기가 완료되었습니다.");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void write(String fileName) {
        try (FileOutputStream output = new FileOutputStream(fileName)) {
            
            String sentence = "Today is Java day";
            byte[] buffers = sentence.getBytes();
            output.write(buffers);
            output.flush();    // 파일에 쓰기
            output.close();    // 파일 닫기
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void copy(String fileName, String copyName) {
        
        FileOutputStream output = null;
        FileInputStream input = null;
        
        try {
            
            input = new FileInputStream(fileName);
            output = new FileOutputStream(copyName);
            
            int readBuffer = 0;
            byte[] buffers = new byte[512];
            
            while ((readBuffer = input.read(buffers)) != -1) {
                output.write(buffers, 0, readBuffer);
            }
            
            output.flush();
 
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                output.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
           
        }
    }
    
    public static void compress(String copyName, String compressName) {
        
        BufferedReader br = null;
        BufferedOutputStream bos = null;
        
        try {
            // BufferedOutputStream -> GZIPOutStream -> FileOutputStream으로 흐름
            // 데이터가 흘러간다는 느낌을 받아야 함
            
            br = new BufferedReader(new FileReader(copyName));
            bos = new BufferedOutputStream(
                    new GZIPOutputStream(new FileOutputStream(compressName)));
            
            String s;
            while (null != (s = br.readLine())) {
                bos.write(s.getBytes());
                bos.write("\n".getBytes());
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bos.close();
                System.out.println(compressName + " 파일의 압축이 완료됐습니다.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        
        String fileName = "data.txt";
        String copyName = "dataCopy.txt";
        
        // 기존 파일 출력
        print(fileName);
        
        // 파일 작성
        write(fileName);
        
        // 파일 복사
        copy(fileName, copyName);
        
        // 파일 출력
        print(copyName);
        
        // 파일 압축
        String compressName = "dataCopy.zip";
        compress(copyName, compressName);
    }
}
