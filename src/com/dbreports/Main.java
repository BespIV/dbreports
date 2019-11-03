package com.dbreports;

public class Main {
    public static void main(String[] args) {
        Debugger.out("App started!");
        Config config = new Config();
        if (config.correct){
            Database db = new Database(config.pathDB,config.nameMainDb);
        }

    }
}
