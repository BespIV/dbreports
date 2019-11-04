package com.dbreports;

import com.dbreports.utils.Debugger;
import com.dbreports.utils.RandomUtil;

public class Main {
    public static void main(String[] args) {
        Debugger.out("Main","App started!");
        Config config = new Config();
        if (config.correct){
            Database db = new Database(config.pathDB,config.nameMainDb);
            RandomUtil rand = new RandomUtil();
            //подключение к БД
            db.connect();
            db.initNewDb();
            //наполнение таблицы cases данными
            int numCases = 10;
            while (numCases>0){
                Case person = new Case(rand.getRandomString(6), rand.getRandomString(6), rand.getRandomDate(2019), rand.getRandomBoolean());
                db.addCase(person);
                numCases--;
            }
            //вывод данных таблицы в консоль
            db.selectAll();
        }


    }
}
