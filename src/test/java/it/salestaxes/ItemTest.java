package it.salestaxes;

import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class ItemTest {
	
    @Test public void testTaxOfItemBook() {
        Item classUnderTest = new Item("book",new BigDecimal("12.49"),Type.BOOK_ITEM,false);
        assertTrue("tax of book should be 0: "+classUnderTest.getTax(), BigDecimal.ZERO.compareTo(classUnderTest.getTax())==0);
    }
    @Test public void testTaxOfMusicCD() {
        Item classUnderTest = new Item("music CD",new BigDecimal("14.99"),Type.OTHER_ITEM,false);
        assertTrue("tax of music CD should be 1.5: "+classUnderTest.getTax(), new BigDecimal("1.5").compareTo(classUnderTest.getTax())==0);
    }
    @Test public void testTaxOfChocholateBar() {
        Item classUnderTest = new Item("chocolate bar",new BigDecimal("0.85"),Type.FOOD_ITEM,false);
        assertTrue("tax of chocolate bar should be 0: "+classUnderTest.getTax(), BigDecimal.ZERO.compareTo(classUnderTest.getTax())==0);
    }
    
   @Test public void testTaxOfImportedItemBoxChocolates_basket2() {
        Item classUnderTest = new Item("box of chocolates",new BigDecimal("10"),Type.FOOD_ITEM,true);
        assertTrue("tax of imported box of chocolates should be 0.50: "+classUnderTest.getTax(), new BigDecimal("0.50").compareTo(classUnderTest.getTax())==0);
    }
    @Test public void testTaxOfImportedItemBottlePerfume_basket2() {
        Item classUnderTest = new Item("bottle of perfume",new BigDecimal("47.50"),Type.OTHER_ITEM,true);
        assertTrue("tax of imported bottle of perfume should be 7.15: "+classUnderTest.getTax(), new BigDecimal("7.15").compareTo(classUnderTest.getTax())==0);
    }
    
    @Test public void testTaxOfImportedItemBottlePerfume_basket3() {
        Item classUnderTest = new Item("bottle of perfume",new BigDecimal("27.99"),Type.OTHER_ITEM,true);
        assertTrue("tax of imported bottle of perfume should be 4.20: "+classUnderTest.getTax(), new BigDecimal("4.20").compareTo(classUnderTest.getTax())==0);
    }
    @Test public void testTaxOfItemBottlePerfume_basket3() {
        Item classUnderTest = new Item("bottle of perfume",new BigDecimal("18.99"),Type.OTHER_ITEM,false);
        assertTrue("tax of bottle of perfume should be 1.90: "+classUnderTest.getTax(), new BigDecimal("1.90").compareTo(classUnderTest.getTax())==0);
    }
    @Test public void testTaxOfItemPills_basket3() {
        Item classUnderTest = new Item("packet of headache pills",new BigDecimal("9.75"),Type.MEDICAL_ITEM,false);
        assertTrue("tax of packet of headache pills should be 0: "+classUnderTest.getTax(), BigDecimal.ZERO.compareTo(classUnderTest.getTax())==0);
    }
    @Test public void testTaxOfImportedItemChocolates_basket3() {
        Item classUnderTest = new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true);
        assertTrue("tax of imported toy should be 0.60: "+classUnderTest.getTax(), new BigDecimal("0.60").compareTo(classUnderTest.getTax())==0);
    }
    
    @Test public void testToStringOfImportedItemBottlePerfume_basket3() {
        Item classUnderTest = new Item("bottle of perfume",new BigDecimal("27.99"),Type.OTHER_ITEM,true);
        assertTrue("string of imported bottle of perfume should be 'imported bottle of perfume: 32.19'", "imported bottle of perfume: 32.19".equals(classUnderTest.toString()));
    }
    @Test public void testToStringOfItemBottlePerfume_basket3() {
        Item classUnderTest = new Item("bottle of perfume",new BigDecimal("18.99"),Type.OTHER_ITEM,false);
        assertTrue("string of bottle of perfume should be 'bottle of perfume: 20.89'", "bottle of perfume: 20.89".equals(classUnderTest.toString()));
    }
    
    @Test public void testToStringTaxFreeOfImportedItemBoxChocolates_basket2() {
        Item classUnderTest = new Item("box of chocolates",new BigDecimal(10),Type.FOOD_ITEM,true);
        assertTrue("string of bottle of perfume should be 'imported box of chocolates at 10.00'", "imported box of chocolates at 10.00".equals(classUnderTest.toStringTaxFree()));
    }
    
    @Test public void testEqualsItems() {
        Item classUnderTestA = new Item("box of chocolates",new BigDecimal(10),Type.FOOD_ITEM,true);
        Item classUnderTestB = new Item("box of chocolates",new BigDecimal(10),Type.FOOD_ITEM,true);
        assertTrue("object is equals", classUnderTestA.equals(classUnderTestB)==true);
    }
    @Test public void testNotEqualsItems() {
        Item classUnderTestA = new Item("box of chocolates",new BigDecimal(10),Type.FOOD_ITEM,true);
        Item classUnderTestB = new Item("bottle of perfume",new BigDecimal("18.99"),Type.OTHER_ITEM,false);
        assertTrue("object is not equals", classUnderTestA.equals(classUnderTestB)==false);
    }
 
}

