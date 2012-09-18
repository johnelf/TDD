package com.jinwen.tax;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/18/12
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReceiptDetails {
    public Map<String, Goods> list = new HashMap<String, Goods>();
    private double saleTaxes = 0.0;
    private double total = 0.0;

    public double calSaleTaxes(){
        Set set = list.entrySet();
        Iterator it=set.iterator();
        while(it.hasNext()){
            Map.Entry<String, Goods>  entry=(Map.Entry<String, Goods>) it.next();
            saleTaxes += entry.getValue().getPriceTag();
        }
        return saleTaxes;
    }
}
