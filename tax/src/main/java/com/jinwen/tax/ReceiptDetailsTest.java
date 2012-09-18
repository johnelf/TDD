package com.jinwen.tax;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/18/12
 * Time: 11:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReceiptDetailsTest extends TestCase {

    public void setUp() throws Exception {
    }

    public void testCalSaleTaxes() throws Exception {
        ReceiptDetails details = new ReceiptDetails();
        Goods book = new Goods("book", 12.49, 1, true, false);
        details.list.put("book", book);

        assertEquals(12.49, details.calSaleTaxes());
    }
}
