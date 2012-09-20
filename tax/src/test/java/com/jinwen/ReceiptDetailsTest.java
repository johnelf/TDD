package com.jinwen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/19/12
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReceiptDetailsTest {
    private Goods book = new Goods("book", 12.49, 1, true, false);
    private Goods musicCD = new Goods("musicCD", 14.99, 1, false, false);
    private Goods chocolateBar = new Goods("chocolate bar", 0.85, 1, true, false);
    private Goods importedBottleOfPerfume = new Goods("imported bottle of perfume", 47.50, 1, false, true);
    private Goods importedBoxOfChocolates = new Goods("imported box of chocolates", 10.00, 1, true, true);

    private ShoppingBasket shoppingCar = new ShoppingBasket();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCalSaleTaxesWithExempt() {
        shoppingCar.addGoods(book);
        shoppingCar.addGoods(musicCD);
        shoppingCar.addGoods(chocolateBar);

        Assert.assertEquals(1.50, shoppingCar.getReceipt().calSaleTaxes(), 0.001f);
    }

    @Test
    public void testCalSaleTaxesWithImported() {
        shoppingCar.addGoods(importedBottleOfPerfume);
        shoppingCar.addGoods(importedBoxOfChocolates);

        Assert.assertEquals(7.65, shoppingCar.getReceipt().calSaleTaxes(), 0.001f);
    }

    @Test
    public void testCalTotalWithExempt() {
        shoppingCar.addGoods(book);
        shoppingCar.addGoods(musicCD);
        shoppingCar.addGoods(chocolateBar);

        Assert.assertEquals(29.83, shoppingCar.getReceipt().calToTal(), 0.001f);
    }

    @Test
    public void testCalTotalWithImported() {
        shoppingCar.addGoods(importedBottleOfPerfume);
        shoppingCar.addGoods(importedBoxOfChocolates);

        Assert.assertEquals(65.15, shoppingCar.getReceipt().calToTal(), 0.001f);
    }

}
