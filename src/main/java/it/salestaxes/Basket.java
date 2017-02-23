package it.salestaxes;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Vector;

public class Basket {
	
	private BigDecimal price_tax_free_tot = BigDecimal.ZERO;
	private BigDecimal tax_tot = BigDecimal.ZERO;
	private String name = "";
	private Vector<ItemCart> list = new Vector<ItemCart>();
	
	
	public Basket(String name)  {
		this.name=name;
	}
	
	public void add(Item item) {

		if(item!=null){
			
			boolean insert=true;

			for(int i=0;i<list.size();i++){
				if(item.equals(list.get(i).getItem())) {
					list.get(i).add();
					insert=false;
					break;
				}
			}

			if(insert)
				list.add(new ItemCart(item));

			calc();
		}
	}
	
	public void sub(Item item) {
				
		if(item!=null){
			for(int i=0;i<list.size();i++){
				if(item.equals(list.get(i).getItem())) {
					if(list.get(i).getCount()>1) {
						list.get(i).sub();
						break;
					}
					else{
						list.remove(i);
						break;
					}
				}
			}
			calc();
		}
	}
	
	private void calc() {
		
		price_tax_free_tot = BigDecimal.ZERO;	
		tax_tot = BigDecimal.ZERO;
		
		Iterator<ItemCart> i = list.iterator();
		while(i.hasNext()){
			ItemCart  iter = i.next();
			BigDecimal x = new BigDecimal(iter.getCount());
			price_tax_free_tot = price_tax_free_tot.add(iter.getItem().getPrice().multiply(x));
			tax_tot = tax_tot.add(iter.getItem().getTax().multiply(x));
		}
		
	}
	
	public String toString() {
		
		DecimalFormat df = new DecimalFormat("###,##0.00");
		String str = name+":\n";
		
		for(int i=0;i<list.size();i++){
			str = str+list.get(i).getCount()+" "+list.get(i).getItem().toString()+"\n";
		}
		str = str+"Sales Taxes: "+df.format(tax_tot)+"\n";
		str = str+"Total: "+df.format(price_tax_free_tot.add(tax_tot))+"\n";
		return str;
		
	}

	public BigDecimal getPrice_tot() {
		return price_tax_free_tot.add(tax_tot);
	}
	
	public BigDecimal getPrice_tax_free_tot() {
		return price_tax_free_tot;
	}

	public BigDecimal getTax_tot() {
		return tax_tot;
	}

}
