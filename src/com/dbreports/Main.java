package com.dbreports;

public class Main {
    public static void main(String[] args) {
        Debugger.out("App started!");
        Config config = new Config();
        Debugger.out(config.author);
        Debugger.out(config.pathDB);
        Debugger.out(config.userDB);
        Debugger.out(config.passDB);
    }
}
