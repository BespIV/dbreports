package com.dbreports;

import java.io.File;
import java.sql.*;

public class Database {
    public String connectionString;
    public Connection conn;
    public Statement stat;
    public ResultSet resSet;

    Database(String pathDB, String nameDB){
        connectionString = "jdbc:sqlite:"+pathDB+nameDB;
        if (existDb(pathDB+nameDB)){
            connect();
        } else {
            Debugger.out("База данных " + pathDB + nameDB + " не существует");
        }
    }

    public void connect(){
        try {
            conn = DriverManager.getConnection(connectionString);
            if (conn != null){
                Debugger.out("База данных подключена");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Boolean existDb(String pathDb){
        File db = new File(pathDb);
        if (db.exists()){
            return true;
        } else {
            return false;
        }
    }
}
