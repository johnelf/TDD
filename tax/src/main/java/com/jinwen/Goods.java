package com.jinwen;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/18/12
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Goods {
    private String goodsName;
    private double priceTag;
    private int goodsAmount;
    private boolean isExempt;
    private boolean isImported;

    public Goods(){
        goodsName = "UNINITIALIZED";
        priceTag = 0.0;
        goodsAmount = 0;
        isExempt = false;
        isImported = false;
    }

    public Goods(String goodsName, double priceTag, int goodsAmount, boolean isExempt, boolean isImported){
        this.goodsName = goodsName;
        this.priceTag = priceTag;
        this.goodsAmount = goodsAmount;
        this.isExempt = isExempt;
        this.isImported = isImported;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public int getGoodsAmount() {
        return goodsAmount;
    }

    public double getPriceTag() {
        return priceTag;
    }

    public boolean isExempt() {
        return isExempt;
    }

    public boolean isImported() {
        return isImported;
    }

    public void addGoods(int amount) {
        if (amount <= 0){
            return;
        }
        this.goodsAmount += amount;
    }

    public void removeGoods(int amount) {
        if (amount <= 0){
            return;
        }
        if (this.goodsAmount <= amount){
            this.goodsAmount = 0;
        }
        else {
            this.goodsAmount -= amount;
        }
    }
}
