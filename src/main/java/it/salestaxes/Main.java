package it.salestaxes;

import java.math.BigDecimal;


public class Main {

	public static void main(String[] args) {
		
    	Basket bsk1 = new Basket("One");
    	bsk1.add(new Item("book",new BigDecimal("12.49"),Type.BOOK_ITEM,false));
    	bsk1.add(new Item("music CD",new BigDecimal("14.99"),Type.OTHER_ITEM,false));
    	bsk1.add(new Item("chocolate bar",new BigDecimal("0.85"),Type.FOOD_ITEM,false));
    	System.out.println(bsk1.toString());
    	
    	Basket bsk2 = new Basket("Two");
    	bsk2.add(new Item("box of chocolates",new BigDecimal("10"),Type.FOOD_ITEM,true));
    	bsk2.add(new Item("bottle of perfume",new BigDecimal("47.50"),Type.OTHER_ITEM,true));
    	System.out.println(bsk2.toString());
    	
    	Basket bsk3 = new Basket("Three");
    	bsk3.add(new Item("bottle of perfume",new BigDecimal("27.99"),Type.OTHER_ITEM,true));
    	bsk3.add(new Item("bottle of perfume",new BigDecimal("18.99"),Type.OTHER_ITEM,false));
    	bsk3.add(new Item("packet of headache pills",new BigDecimal("9.75"),Type.MEDICAL_ITEM,false));
    	bsk3.add(new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true));
    	System.out.println(bsk3.toString());
    	
    	Basket bskEmpty = new Basket("Empty");
    	System.out.println(bskEmpty.toString());
    	
    	Basket bskVar = new Basket("Various");
    	bskVar.sub(new Item("music CD",new BigDecimal("14.99"),Type.OTHER_ITEM,false));
    	bskVar.add(new Item("bottle of perfume",new BigDecimal("27.99"),Type.OTHER_ITEM,true));
    	bskVar.add(new Item("music CD",new BigDecimal("14.99"),Type.OTHER_ITEM,false));
    	bskVar.add(new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true));
    	bskVar.add(new Item("bottle of perfume",new BigDecimal("18.99"),Type.OTHER_ITEM,false));
    	bskVar.add(new Item("packet of headache pills",new BigDecimal("9.75"),Type.MEDICAL_ITEM,false));
    	bskVar.add(new Item("packet of headache pills",new BigDecimal("9.75"),Type.MEDICAL_ITEM,false));
    	bskVar.add(new Item("chocolates",new BigDecimal("11.25"),Type.FOOD_ITEM,true));
    	bskVar.add(new Item("bottle of perfume",new BigDecimal("18.99"),Type.OTHER_ITEM,false));
    	bskVar.sub(new Item("music CD",new BigDecimal("14.99"),Type.OTHER_ITEM,false));
    	bskVar.add(new Item("packet of headache pills",new BigDecimal("9.75"),Type.MEDICAL_ITEM,false));
    	bskVar.add(new Item("bottle of perfume",new BigDecimal("27.99"),Type.OTHER_ITEM,true));
    	System.out.println(bskVar.toString());
	}

}
