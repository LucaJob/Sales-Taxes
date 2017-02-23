package it.salestaxes;

import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class BasketTest {

    @Test public void testTaxBasket1() {
    	Basket classUnderTest = new Basket("One");
    	classUnderTest.add(new Item("book",new BigDecimal("12.49"),Type.BOOK_ITEM,false));
    	classUnderTest.add(new Item("music CD",new BigDecimal("14.99"),Type.OTHER_ITEM,false));
    	classUnderTest.add(new Item("chocolate bar",new BigDecimal("0.85"),Type.FOOD_ITEM,false));
        assertTrue("tax of basket One should be 1.50", new BigDecimal("1.50").compareTo(classUnderTest.getTax_tot())==0);
    }
    
    @Test public void testPriceBasket1() {
    	Basket classUnderTest = new Basket("One");
    	classUnderTest.add(new Item("book",new BigDecimal("12.49"),Type.BOOK_ITEM,false));
    	classUnderTest.add(new Item("music CD",new BigDecimal("14.99"),Type.OTHER_ITEM,false));
    	classUnderTest.add(new Item("chocolate bar",new BigDecimal("0.85"),Type.FOOD_ITEM,false));
        assertTrue("price of basket One should be 29.83", new BigDecimal("29.83").compareTo(classUnderTest.getPrice_tot())==0);
    }
    
    @Test public void testTaxBasket2() {
    	Basket classUnderTest = new Basket("Two");
    	classUnderTest.add(new Item("box of chocolates",new BigDecimal("10"),Type.FOOD_ITEM,true));
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("47.50"),Type.OTHER_ITEM,true));
        assertTrue("tax of basket Two should be 7.65", new BigDecimal("7.65").compareTo(classUnderTest.getTax_tot())==0);
    }
    
    @Test public void testPriceBasket2() {
    	Basket classUnderTest = new Basket("Two");
    	classUnderTest.add(new Item("box of chocolates",new BigDecimal("10"),Type.FOOD_ITEM,true));
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("47.50"),Type.OTHER_ITEM,true));
        assertTrue("price of basket Two should be 65.15", new BigDecimal("65.15").compareTo(classUnderTest.getPrice_tot())==0);
    }
    
    @Test public void testTaxBasket3() {
    	Basket classUnderTest = new Basket("Three");
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("27.99"),Type.OTHER_ITEM,true));
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("18.99"),Type.OTHER_ITEM,false));
    	classUnderTest.add(new Item("packet of headache pills",new BigDecimal("9.75"),Type.MEDICAL_ITEM,false));
    	classUnderTest.add(new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true));
        assertTrue("tax of basket Three should be 6.70", new BigDecimal("6.70").compareTo(classUnderTest.getTax_tot())==0);
    }
    
    @Test public void testPriceBasket3() {
    	Basket classUnderTest = new Basket("Three");
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("27.99"),Type.OTHER_ITEM,true));
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("18.99"),Type.OTHER_ITEM,false));
    	classUnderTest.add(new Item("packet of headache pills",new BigDecimal("9.75"),Type.MEDICAL_ITEM,false));
    	classUnderTest.add(new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true));
        assertTrue("price of basket Three should be 74.68", new BigDecimal("74.68").compareTo(classUnderTest.getPrice_tot())==0);
    }
    
    @Test public void testTaxBasketEmpty() {
    	Basket classUnderTest = new Basket("Empty");
        assertTrue("tax of basket Empty should be 0", BigDecimal.ZERO.compareTo(classUnderTest.getTax_tot())==0);
    }
    
    @Test public void testPriceBasketEmpty() {
    	Basket classUnderTest = new Basket("Empty");
        assertTrue("price of basket Empty should be 0", BigDecimal.ZERO.compareTo(classUnderTest.getPrice_tot())==0);
    }
    
    @Test public void testToStringBasketEmpty() {
    	Basket classUnderTest = new Basket("Empty");
        assertTrue("toString of basket Empty should be 'Empty: Sales Taxes: 0.00 Total: 0.00'", "Empty:\nSales Taxes: 0.00\nTotal: 0.00\n".equals(classUnderTest.toString()));
    }
    
    
    @Test public void testTaxBasketFilledEmptied() {
    	Basket classUnderTest = new Basket("Filled_Emptied");
    	classUnderTest.add(new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true));
    	classUnderTest.add(new Item("chocolate bar",new BigDecimal("0.85"),Type.FOOD_ITEM,false));
    	classUnderTest.sub(new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true));
    	classUnderTest.sub(new Item("chocolate bar",new BigDecimal("0.85"),Type.FOOD_ITEM,false));
        assertTrue("tax of basket Emptied should be 0", BigDecimal.ZERO.compareTo(classUnderTest.getTax_tot())==0);
    }
    
    @Test public void testPriceBasketFilledEmptied() {
    	Basket classUnderTest = new Basket("Filled_Emptied");
    	classUnderTest.add(new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true));
    	classUnderTest.add(new Item("chocolate bar",new BigDecimal("0.85"),Type.FOOD_ITEM,false));
    	classUnderTest.sub(new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true));
    	classUnderTest.sub(new Item("chocolate bar",new BigDecimal("0.85"),Type.FOOD_ITEM,false));
        assertTrue("price of basket Emptied should be 0", BigDecimal.ZERO.compareTo(classUnderTest.getPrice_tot())==0);
    }
    
    @Test public void testTaxBasketEmptied() {
    	Basket classUnderTest = new Basket("Emptied");
    	classUnderTest.sub(new Item("packet of headache pills",new BigDecimal("9.75"),Type.MEDICAL_ITEM,false));
    	classUnderTest.sub(new Item("music CD",new BigDecimal("14.99"),Type.OTHER_ITEM,false));
        assertTrue("tax of basket Emptied should be 0", BigDecimal.ZERO.compareTo(classUnderTest.getTax_tot())==0);
    }
    
    @Test public void testPriceBasketEmptied() {
    	Basket classUnderTest = new Basket("Emptied");
    	classUnderTest.sub(new Item("packet of headache pills",new BigDecimal("9.75"),Type.MEDICAL_ITEM,false));
    	classUnderTest.sub(new Item("music CD",new BigDecimal("14.99"),Type.OTHER_ITEM,false));
        assertTrue("price of basket Emptied should be 0", BigDecimal.ZERO.compareTo(classUnderTest.getPrice_tot())==0);
    }
    
    @Test public void testTaxBasketDouble3() {
    	Basket classUnderTest = new Basket("Double Three");
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("27.99"),Type.OTHER_ITEM,true));
    	classUnderTest.add(new Item("music CD",new BigDecimal("14.99"),Type.OTHER_ITEM,false));
    	classUnderTest.add(new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true));
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("18.99"),Type.OTHER_ITEM,false));
    	classUnderTest.add(new Item("packet of headache pills",new BigDecimal("9.75"),Type.MEDICAL_ITEM,false));
    	classUnderTest.add(new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true));
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("18.99"),Type.OTHER_ITEM,false));
    	classUnderTest.sub(new Item("music CD",new BigDecimal("14.99"),Type.OTHER_ITEM,false));
    	classUnderTest.add(new Item("packet of headache pills",new BigDecimal("9.75"),Type.MEDICAL_ITEM,false));
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("27.99"),Type.OTHER_ITEM,true));
        assertTrue("tax of basket Three should be 13.40", new BigDecimal("13.40").compareTo(classUnderTest.getTax_tot())==0);
    }
    
    @Test public void testPriceBasketDouble3() {
    	Basket classUnderTest = new Basket("Double Three");
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("27.99"),Type.OTHER_ITEM,true));
    	classUnderTest.add(new Item("music CD",new BigDecimal("14.99"),Type.OTHER_ITEM,false));
    	classUnderTest.add(new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true));
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("18.99"),Type.OTHER_ITEM,false));
    	classUnderTest.add(new Item("packet of headache pills",new BigDecimal("9.75"),Type.MEDICAL_ITEM,false));
    	classUnderTest.add(new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true));
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("18.99"),Type.OTHER_ITEM,false));
    	classUnderTest.sub(new Item("music CD",new BigDecimal("14.99"),Type.OTHER_ITEM,false));
    	classUnderTest.add(new Item("packet of headache pills",new BigDecimal("9.75"),Type.MEDICAL_ITEM,false));
    	classUnderTest.add(new Item("bottle of perfume",new BigDecimal("27.99"),Type.OTHER_ITEM,true));
        assertTrue("price of basket Three should be 149.36", new BigDecimal("149.36").compareTo(classUnderTest.getPrice_tot())==0);
    }
    
}
