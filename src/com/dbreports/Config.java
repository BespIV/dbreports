package com.dbreports;

import com.dbreports.utils.Debugger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class Config {
    boolean correct = false;
    String pathApp;
    String pathDB;
    String pathWorkspace;
    String nameMainDb;

    Config() {
        this.pathApp = System.getProperty("user.dir");
        loadPropertiesFromFile();
        checkConfigVars();
    }

    private void loadPropertiesFromFile(){
        try {
            File configFile = new File(".", "resources/config.properties");
            FileInputStream streamConfig = new FileInputStream(configFile);
            Properties props = new Properties();
            props.load(streamConfig);
            pathDB = pathApp + props.getProperty("pathDB").replace("/", "\\");
            pathWorkspace = pathApp + props.getProperty("pathWorkspace").replace("/", "\\");
            nameMainDb = props.getProperty("nameMainDb");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void checkConfigVars(){
        if (pathDB == null){
            Debugger.out("Config", "pathDB не задан");
        }else if(pathWorkspace == null){
            Debugger.out("Config", "pathWorkspace не задан");
        }else if(nameMainDb == null){
            Debugger.out("Config", "nameMainDb не задан");
        }else {
            correct = true;
            Debugger.out("Config", "Конфигурация загружена успешно");
        }
    }
}
