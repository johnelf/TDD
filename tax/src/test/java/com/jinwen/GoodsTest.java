package com.jinwen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/20/12
 * Time: 11:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoodsTest {
    private Goods book;

    @Before
    public void setUp() throws Exception {
        book = new Goods("book", 12.49, 2, true, false);
    }

    @Test
    public void testAddGoodsWithNegativeNumber() {
        book.addGoods(-1);
        Assert.assertEquals(2, book.getGoodsAmount());
    }

    @Test
    public void testAddGoodsWithPositiveNumber() {
        book.addGoods(2);
        Assert.assertEquals(4, book.getGoodsAmount());
    }

    @Test
    public void testRemoveGoodsWithNegativeNumber() {
        book.removeGoods(-1);
        Assert.assertEquals(2, book.getGoodsAmount());
    }

    @Test
    public void testRemoveGoodsWithPositiveNumberWhichLargerThanGoodsNumber() {
        book.removeGoods(3);
        Assert.assertEquals(0, book.getGoodsAmount());
    }

    @Test
    public void testRemoveGoodsWithPositiveNumberWhichLessThanGoodsNumber() {
        book.removeGoods(1);
        Assert.assertEquals(1, book.getGoodsAmount());
    }
}
