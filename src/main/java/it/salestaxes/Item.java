package it.salestaxes;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Item {
	
	private String name = "";
	private BigDecimal price = BigDecimal.ZERO;
	private BigDecimal tax = BigDecimal.ZERO;
	private Type type = Type.OTHER_ITEM;
	private boolean imported=false;
	
	public Item(String name, BigDecimal price, Type type, boolean imported)  {
		this.name=name;
		this.price=price;
		this.type=type;
		this.imported=imported;
		taxCalc();
	}
	
	private void taxCalc() {
		
		int perc = type.getPerc();
		
		if(imported)
			perc=perc+5;
		
		this.tax = round(price.multiply(new BigDecimal(perc)).divide(new BigDecimal(100)));
		
	}
	
	private BigDecimal round(BigDecimal num) {
		
		BigDecimal value = num.divide(new BigDecimal(0.05), 0, BigDecimal.ROUND_UP).multiply(new BigDecimal(0.05));
		return value.setScale(2,BigDecimal.ROUND_DOWN);
		
	}
	
	public String toString() {
		String str = "";
		DecimalFormat df = new DecimalFormat("###,##0.00");
		
		if(imported)
			str="imported ";
		
		str=str+this.name+": "+df.format(price.add(tax));
		
		return str;
	}
	
	public String toStringTaxFree() {
		String str = "";
		DecimalFormat df = new DecimalFormat("###,##0.00");
		
		if(imported)
			str="imported ";
		
		str=str+this.name+" at "+df.format(price);
		
		return str;
	}
	
	public boolean equals(Item item) {
		if(this.name.equals(item.getName()) && (this.imported == item.isImported()) &&
				this.type.equals(item.getType()) && this.price.compareTo(item.getPrice())==0)
			return true;
		else
			return false;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getTax() {
		return tax;
	}
	
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public boolean isImported() {
		return imported;
	}
	
	public void setImported(boolean imported) {
		this.imported = imported;
	}


}
