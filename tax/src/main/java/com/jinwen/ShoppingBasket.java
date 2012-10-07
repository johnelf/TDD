package com.jinwen;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/18/12
 * Time: 10:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingBasket {
    private ArrayList<Goods> basket = new ArrayList<Goods>();

    public ArrayList<Goods> getReceipt(){
        return basket;
    }

    public boolean isEmpty(){
        return basket.isEmpty() ? true : false;
    }

    public void addGoods(Goods goods) {
        basket.add(goods);
    }

    public void dropGoods(Goods goods){
        basket.remove(goods);
    }
}
