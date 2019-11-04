package com.dbreports;

import com.dbreports.utils.Debugger;

public class Main {
    public static void main(String[] args) {
        Debugger.out("Main","App started!");
        Config config = new Config();
        if (config.correct){
            Database db = new Database(config.pathDB,config.nameMainDb);
            db.connect();
            db.initNewDb();
            Case person1 = new Case("box", "Vasya", "2019-02-03", true);
            db.addCase(person1);
        }


    }
}
