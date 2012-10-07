package com.jinwen;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/7/12
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingMain {
    public static void main(){
        ShoppingMain shoppingMain = new ShoppingMain();
        Goods book = new Goods("book", 12.49, 1, true, false);
        Goods musicCD = new Goods("musicCD", 14.99, 1, false, false);
        Goods chocolateBar = new Goods("chocolate bar", 0.85, 1, true, false);
        Goods importedBottleOfPerfume = new Goods("imported bottle of perfume", 47.50, 1, false, true);
        Goods importedBoxOfChocolates = new Goods("imported box of chocolates", 10.00, 1, true, true);

        ShoppingBasket shoppingBasket1 = new ShoppingBasket();
        ShoppingBasket shoppingBasket2 = new ShoppingBasket();
        Checkout checkout = new Checkout();

        shoppingBasket1.addGoods(book);
        shoppingBasket1.addGoods(musicCD);
        shoppingBasket1.addGoods(chocolateBar);

        checkout.getBasket(shoppingBasket1);
        checkout.printReceipt();

        shoppingBasket2.addGoods(importedBottleOfPerfume);
        shoppingBasket2.addGoods(importedBoxOfChocolates);

        checkout.getBasket(shoppingBasket2);
        checkout.printReceipt();
    }
}
