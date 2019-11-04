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
        nameDb = nameDB;
    }

    public void connect(){
        try {
            conn = DriverManager.getConnection(connectionString);
            stat = conn.createStatement();
            if (conn != null) {
                Debugger.out("Database", "Connect to " + connectionString + " SUCCESS!");
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
            stat.execute("CREATE TABLE IF NOT EXISTS 'cases' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'product' text, 'customer' text, 'dateInserting' date, 'signOON' boolean);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCase(Case oneCase){
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO cases('product', 'customer', 'dateInserting', 'signOON') VALUES(?,?,?,?)");
            statement.setObject(1, oneCase.product);
            statement.setObject(2, oneCase.customer);
            statement.setObject(3, oneCase.dateInserting);
            statement.setObject(4, oneCase.signOON);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeSQL(String query) {
        try {
            stat.execute(query);
            Debugger.out("Database", "Выполнен запрос: " + query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAll(){
        try {
            resSet = stat.executeQuery("SELECT * FROM cases");
            while (resSet.next()){
                Debugger.out("SQL",
                        resSet.getString(1)+ " | " +
                        resSet.getString(2)+ " | " +
                        resSet.getString(3) + " | " +
                        resSet.getString(4) + " | " +
                        resSet.getString(5)
                );
            }
            resSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeDB(){
        try {
            resSet.close();
            stat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
