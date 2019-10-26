package com.dbreports;

public class Main {
    public static void main(String[] args) {
        Debugger.out("App started!");
        new Config();
        Debugger.out(Config.author);
        Debugger.out(Config.pathDB);
        Debugger.out(Config.userDB);
        Debugger.out(Config.passDB);
    }
}
