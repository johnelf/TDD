package com.jinwen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/7/12
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class CheckoutTest {
    private Goods book = new Goods("book", 12.49, 1, true, false);
    private Goods musicCD = new Goods("musicCD", 14.99, 1, false, false);
    private Goods chocolateBar = new Goods("chocolate bar", 0.85, 1, true, false);
    private Goods importedBottleOfPerfume = new Goods("imported bottle of perfume", 47.50, 1, false, true);
    private Goods importedBoxOfChocolates = new Goods("imported box of chocolates", 10.00, 1, true, true);

    private ShoppingBasket shoppingBasket = new ShoppingBasket();
    private Checkout checkout = new Checkout();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCalSaleTaxesWithExempt() {
        shoppingBasket.addGoods(book);
        shoppingBasket.addGoods(musicCD);
        shoppingBasket.addGoods(chocolateBar);
        checkout.getBasket(shoppingBasket);

        Assert.assertEquals(1.50, checkout.calSaleTaxes(), 0.001f);
    }

    @Test
    public void testCalSaleTaxesWithImported() {
        shoppingBasket.addGoods(importedBottleOfPerfume);
        shoppingBasket.addGoods(importedBoxOfChocolates);
        checkout.getBasket(shoppingBasket);

        Assert.assertEquals(7.65, checkout.calSaleTaxes(), 0.001f);
    }

    @Test
    public void testCalTotalWithExempt() {
        shoppingBasket.addGoods(book);
        shoppingBasket.addGoods(musicCD);
        shoppingBasket.addGoods(chocolateBar);
        checkout.getBasket(shoppingBasket);

        Assert.assertEquals(29.83, checkout.calToTal(), 0.001f);
    }

    @Test
    public void testCalTotalWithImported() {
        shoppingBasket.addGoods(importedBottleOfPerfume);
        shoppingBasket.addGoods(importedBoxOfChocolates);
        checkout.getBasket(shoppingBasket);

        Assert.assertEquals(65.15, checkout.calToTal(), 0.001f);
    }

}
