package com.example.buylist.models;

import java.util.Date;

public class Purchase {

    private ItemLocation itemLocation;
    private Date date;
    private int quantity;

    public Purchase(ItemLocation itemLocation, Date date, int quantity) {
        this.itemLocation = itemLocation;
        this.date = date;
        this.quantity = quantity;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItemLocation(ItemLocation itemLocation) {
        this.itemLocation = itemLocation;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ItemLocation getItemLocation() {
        return itemLocation;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "itemLocation=" + itemLocation.toString() +
                ", date=" + date +
                ", quantity=" + quantity +
                '}';
    }
}
