package com.pobitecoding.property;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class propertyExam {
    
    public static void propertiesRead(String propertyName) {
        
        try (Reader fr = new FileReader(propertyName)) {
            Properties prop = new Properties();
            prop.load(fr);
            
            String androidUseX = prop.getProperty("android.useAndroidX");
            System.out.println("android.useAndroidX : " + androidUseX);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        String propertyName = "gradle.properties";
        propertiesRead(propertyName);
    }
}