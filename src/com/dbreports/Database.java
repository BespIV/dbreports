package com.dbreports;

import com.dbreports.utils.Debugger;

import java.io.File;
import java.sql.*;

public class Database {
    public String connectionString;
    public String pathDb;
    public String nameDb;
    public Connection conn;
    public Statement stat;
    public ResultSet resSet;

    Database(String pathDB, String nameDB){
        connectionString = "jdbc:sqlite:"+pathDB+nameDB;
        pathDb = pathDB;
        nameDb = pathDB;
    }

    public void connect(){
        try {
            conn = DriverManager.getConnection(connectionString);
            stat = conn.createStatement();
            if (conn != null){
                Debugger.out("Database", "Connect to " + connectionString + " SUCCESS!");
            } else{
                Debugger.out("Database","Connect to " + connectionString + " SUCCESS!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void existDb(){
        File db = new File(pathDb+nameDb);
        if (db.exists()){
            Debugger.out("Database","Файл существует "+pathDb+nameDb);
        } else {
            Debugger.out("Database","Файл НЕ существует "+pathDb+nameDb);
        }
    }

    public void initNewDb(){
        try {
            stat.execute("CREATE TABLE IF NOT EXISTS 'cases' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'product' text,'signOON' boolean,'customer' text,'dateInserting' date);");
            Debugger.out("Database","Таблица создана");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCase(Case oneCase){
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO cases('product', 'signOON', 'customer', 'dateInserting') VALUES(?,?,?,?)");
            statement.setObject(1, oneCase.product);
            statement.setObject(2, oneCase.signOON);
            statement.setObject(3, oneCase.customer);
            statement.setObject(4, oneCase.dateInserting);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeSQL(String query) throws SQLException {
        stat.execute(query);
    }



    public void dbToString(){
    }
}
