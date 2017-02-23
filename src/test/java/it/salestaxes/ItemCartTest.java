package it.salestaxes;

import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class ItemCartTest {

    @Test public void testCartSub() {
    	ItemCart classUnderTest = new ItemCart(new Item("box of chocolates",new BigDecimal(10),Type.FOOD_ITEM,true));
    	classUnderTest.setCount(10);
    	classUnderTest.sub();
        assertTrue("count should be 9", 9 == classUnderTest.getCount());
    }
    @Test public void testCartSubZero() {
    	ItemCart classUnderTest = new ItemCart(new Item("box of chocolates",new BigDecimal(10),Type.FOOD_ITEM,true));
    	classUnderTest.setCount(0);
    	classUnderTest.sub();
        assertTrue("count should be 0", 0 == classUnderTest.getCount());
    }
    @Test public void testCartAdd() {
    	ItemCart classUnderTest = new ItemCart(new Item("box of chocolates",new BigDecimal(10),Type.FOOD_ITEM,true));
    	classUnderTest.setCount(10);
    	classUnderTest.add();
        assertTrue("count should be 11", 11 == classUnderTest.getCount());
    }
    
}
