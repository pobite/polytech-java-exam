package com.pobitecoding.extra.singleton;

import java.io.FileWriter;
import java.io.IOException;

public class MyLogger {

    private static MyLogger instance;
    private static FileWriter fw;
    
    private MyLogger() {};
    
    public static MyLogger getInstance() {
        if (instance == null) {
            instance = new MyLogger();
            try {
                fw = new FileWriter("dummylog.txt", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    
    public synchronized void log(String message) {
        
        try {
            fw.write(message + "\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        MyLogger logger1 = MyLogger.getInstance();
        logger1.log("first");
        
        MyLogger logger2 = MyLogger.getInstance();
        logger2.log("second");
    }
}