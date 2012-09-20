package com.jinwen;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.Math.ceil;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/18/12
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReceiptDetails {
    public Map<String, Goods> list = new HashMap<String, Goods>();
    private double saleTaxes;
    private double total;

    private double calTax(double price, double percentage) {
        double tax = 0.0;
        tax = price * percentage;

        tax = (tax * 100) / 5;
        tax = (ceil(tax) * 5) / 100;
        return tax;
    }

    public double calToTal(){
        total = 0.0;
        saleTaxes = 0.0;
        Iterator it = list.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Goods> entry=(Map.Entry<String, Goods>) it.next();
            total += entry.getValue().getPriceTag();
        }
        calSaleTaxes();
        total += saleTaxes;

        return total;
    }

    public double calSaleTaxes(){
        saleTaxes = 0.0;
        Iterator it = list.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Goods> entry=(Map.Entry<String, Goods>) it.next();

            if(entry.getValue().isImported())
            {
                saleTaxes += calTax(entry.getValue().getPriceTag(), 0.05);
            }
            if(!entry.getValue().isExempt())
            {
                saleTaxes += calTax(entry.getValue().getPriceTag(), 0.1);
            }
        }
        return saleTaxes;
    }

    public void listGoodsInfo(){
        Iterator it = list.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Goods> entry=(Map.Entry<String, Goods>) it.next();
            System.out.print(entry.getValue().getGoodsAmount() + " ");
            System.out.print(entry.getValue().getGoodsName() + " at ");
            System.out.println(entry.getValue().getPriceTag());
        }
    }
}
