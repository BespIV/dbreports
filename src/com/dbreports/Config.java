package com.dbreports;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public boolean correct = false;
    public String pathApp;
    public String pathDB;
    public String pathWorkspace;
    public String nameMainDb;

    Config() {
        this.pathApp = System.getProperty("user.dir");
        loadPropertiesFromFile();
        checkConfigVars();
    }

    private void loadPropertiesFromFile(){
        FileInputStream streamConfig;
        try {
            File configFile = new File(".", "resources/config.properties");
            streamConfig = new FileInputStream(configFile);
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
            Debugger.out("pathDB не задан");
        }else if(pathWorkspace == null){
            Debugger.out("pathWorkspace не задан");
        }else if(nameMainDb == null){
            Debugger.out("nameMainDb не задан");
        }else {
            correct = true;
            Debugger.out("Конфигурация загружена успешно");
        }
    }
}
