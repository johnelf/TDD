package com.jinwen;

import static java.lang.Math.ceil;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/7/12
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class Checkout {
    public ShoppingBasket shoppingBasket = new ShoppingBasket();

    private double calTax(double price, double percentage) {
        double tax = 0.0;
        tax = price * percentage;

        tax = (tax * 100) / 5;
        tax = (ceil(tax) * 5) / 100;
        return tax;
    }

    public void getBasket(ShoppingBasket shoppingBasket){
        this.shoppingBasket = shoppingBasket;
    }

    public double calToTal(){
        double total = 0.0;
        double saleTaxes = 0.0;

        if (shoppingBasket.isEmpty()) return 0.0;

        for (Goods var : shoppingBasket.getReceipt()){
            total += (var.getPriceTag() * var.getGoodsAmount());
        }
        total += calSaleTaxes();

        return total;
    }

    public double calSaleTaxes(){
        double saleTaxes = 0.0;
        if (shoppingBasket.isEmpty()) return 0.0;
        for (Goods var : shoppingBasket.getReceipt()){
            if(var.isImported())
            {
                saleTaxes += (var.getGoodsAmount() * calTax(var.getPriceTag(), 0.05));
            }
            if(!var.isExempt())
            {
                saleTaxes += (var.getGoodsAmount() * calTax(var.getPriceTag(), 0.1));
            }
        }
        return saleTaxes;
    }

    public void printReceipt(){
        if (shoppingBasket.isEmpty()) return;
        for (Goods var : shoppingBasket.getReceipt()){
            System.out.print(var.getGoodsAmount() + " ");
            System.out.print(var.getGoodsName() + " at ");
            System.out.println(var.getPriceTag());
        }
        System.out.println("Sales Taxes: " + calSaleTaxes());
        System.out.println("Total: " + calToTal());
    }
}
