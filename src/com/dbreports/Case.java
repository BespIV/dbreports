package com.dbreports;

public class Case {
    public String product;
    public String customer;
    public String dateInserting;
    public Boolean signOON;

    Case(String product,String customer,String dateInserting,Boolean signOON){
        this.product=product;
        this.customer=customer;
        this.dateInserting=dateInserting;
        this.signOON=signOON;
    }

    public String createTable(){
        return "CREATE TABLE IF NOT EXISTS 'cases' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'product' text,'signOON' boolean,'customer' text,'dateInserting' date);";
    }

    public String addToDb(){
        String query = "INSERT INTO 'cases' ('product', 'signOON', 'customer', 'dateInserting') VALUES ("+ product +", "+ signOON +", "+ customer +", "+ dateInserting +");";
        return query;
    }
}
