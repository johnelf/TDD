package com.jinwen.tax;

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
        goodsName = "";
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

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsAmount(int goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public int getGoodsAmount() {
        return goodsAmount;
    }

    public void setPriceTag(double priceTag) {
        this.priceTag = priceTag;
    }

    public double getPriceTag() {
        return priceTag;
    }

    public void setExempt(boolean exempt) {
        isExempt = exempt;
    }

    public boolean isExempt() {
        return isExempt;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public boolean isImported() {
        return isImported;
    }
}
