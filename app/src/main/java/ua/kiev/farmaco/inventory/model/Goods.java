package ua.kiev.farmaco.inventory.model;

/**
 * Author:  Serhii Synohub
 * Date:    01.05.2017
 *
 * This model describes a goods object which will be returned in http reply
 */

public class Goods {

    private String goodName;
    private String goodBarcode;
    private int goodCount;
    private int goodId;


    Goods(String name, String bar, int count, int id){
        this.goodName = name;
        this.goodBarcode = bar;
        this.goodCount = count;
        this.goodId = id;
    }

    public String getGoodName() {
        return this.goodName;
    }

    public String getGoodBarcode() {
        return this.goodBarcode;
    }

    public int getGoodCount() {
        return goodCount;
    }

    public int getGoodId() {
        return this.goodId;
    }
}
