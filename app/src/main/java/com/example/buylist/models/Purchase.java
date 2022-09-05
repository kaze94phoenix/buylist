package com.example.buylist.models;

public class Purchase {

    private ItemLocation itemLocation;
    private int quantity;
    private boolean purchased;

    public Purchase(ItemLocation itemLocation, int quantity) {
        this.itemLocation = itemLocation;
        if(quantity<1)
            this.quantity=1;
        else
            this.quantity = quantity;
        purchased=false;
    }

    public Purchase(){

    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
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

    public ItemLocation getItemLocation() {
        return itemLocation;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "itemLocation=" + itemLocation +
                ", quantity=" + quantity +
                ", purchased=" + purchased +
                '}';
    }
}
