package com.example.buylist.models;

import java.util.ArrayList;
import java.util.Date;

public class BuyList {

    private ArrayList<Purchase> purchases;
    private Date date;

    public BuyList(){

    }

    public BuyList(Date date, ArrayList<Purchase> purchases){
        this.date=date;
        if(purchases!=null)
            this.purchases=purchases;
        else
            purchases = new ArrayList<Purchase>();
    }


    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addToBuyList(Purchase purchase){
        purchases.add(purchase);
    }

    public void addToBuyList(int position, Purchase purchase){
        purchases.add(position,purchase);
    }



}
