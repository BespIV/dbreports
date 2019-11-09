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

    public String toString(){
        String result = product+" "+customer+" "+dateInserting+" "+signOON;
        return result;
    }
}
