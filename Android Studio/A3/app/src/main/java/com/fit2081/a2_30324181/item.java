package com.fit2081.a2_30324181;

public class item {

    public String itemName;
    public int itemQuantity;
    public float itemCost;

    public item(String itemName, int itemQuantity, float itemCost) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemCost = itemCost;
    }

    public String getItemName() {return itemName;}
    public int getItemQuantity() {return itemQuantity;}
    public float getItemCost() {return itemCost; }


}
