package ua.kiev.farmaco.inventory.model;

/**
 * Author:  Serhii Synohub
 * Date:    01.05.2017
 */

public class Good {

    private String goodName;
    private String goodBarcode;
    private int goodId;


    Good(String name, String bar, int id){
        this.goodName = name;
        this.goodBarcode = bar;
        this.goodId = id;
    }

    public String getGoodName() {
        return this.goodName;
    }

    public String getGoodBarcode() {
        return this.goodBarcode;
    }

    public int getGoodId() {
        return this.goodId;
    }
}
