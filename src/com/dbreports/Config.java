package com.dbreports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

class Config {
    static String author;
    static String pathDB;
    static String userDB;
    static String passDB;
    private static File config = new File(".", "resources\\config.properties");
    private static String pathConfig = config.getAbsolutePath();

    Config() {
        try {
            FileInputStream streamConfig = new FileInputStream(pathConfig);
            Properties props = new Properties();
            props.load(streamConfig);
            this.setAuthor(props.getProperty("author"));
            this.setPathDB(props.getProperty("pathDB"));
            this.setUserDB(props.getProperty("userDB"));
            this.setPassDB(props.getProperty("passDB"));
            checkProps();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private void setAuthor (String author){
            this.author = author;
        }

        private void setPathDB (String pathDB){
            this.pathDB = pathDB;
        }

        private void setUserDB (String userDB){
            this.userDB = userDB;
        }

        private void setPassDB (String passDB){
            this.passDB = passDB;
        }

        private void checkProps () {
            if (author != null && pathDB != null && userDB != null && passDB != null) {
                Debugger.out("Конфигурация загружена");
            } else {
                Debugger.out("Есть отсутствующие параметры");
            }
        }
}
