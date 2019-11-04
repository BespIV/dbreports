package com.dbreports;

class Debugger {
    public static void out(String inString){
        System.out.println("[DEBUG]: " + inString);
    }

    public static void out(int inInteger) {
        System.out.println("[DEBUG]: " + String.valueOf(inInteger));
    }
}
