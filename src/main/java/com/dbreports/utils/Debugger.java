package com.dbreports.utils;

public class Debugger {

    public static void out(String classname, String msg){
        System.out.println("["+classname+"]: "+msg);
    }

    public static void out(String classname, int msg){
        System.out.println("["+classname+"]: "+msg);
    }

    public static void out(String msg){
        out("DEBUG", msg);
    }

    public static void out(int inInt) {
        out("DEBUG", inInt);
    }

}
