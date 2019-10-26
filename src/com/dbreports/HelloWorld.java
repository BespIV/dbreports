package com.dbreports;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HelloWorld {
    public static String author;

    public void getAuthor(String properties){
        try {
            FileInputStream cfgStream = new FileInputStream(properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
