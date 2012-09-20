package com.jinwen;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/18/12
 * Time: 10:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingBasket {
    private ReceiptDetails basket = new ReceiptDetails();

    public ReceiptDetails getReceipt(){
        return basket;
    }

    public void addGoods(Goods goods) {
        basket.list.put(goods.getGoodsName(), goods);
    }

    public void dropGoods(Goods goods){
        basket.list.remove(goods);
    }

    public void printReceipt() {
        basket.listGoodsInfo();
        basket.calSaleTaxes();
        basket.calToTal();
    }
}
