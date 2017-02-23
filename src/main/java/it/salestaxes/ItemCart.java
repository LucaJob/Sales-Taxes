package it.salestaxes;

public class ItemCart {
	
	private int count = 0;
	private Item item;
	
	public ItemCart(Item item) {
		count=1;
		this.item=item;
	}
	
	public void add(){
		count=count+1;
	}
	
	public void sub(){
		if(count>0)	
			count=count-1;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	

}
