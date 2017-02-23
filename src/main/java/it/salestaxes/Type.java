package it.salestaxes;

public enum Type {

	BOOK_ITEM("Book",0),
	FOOD_ITEM("Food",0),
	MEDICAL_ITEM("Medical",0),
	OTHER_ITEM("Other",10);
	
	private final String name;
	private final int perc;
	
	Type(String name, int perc)  {
		this.name=name;
		this.perc=perc;
	}

	public String getName() {
		return name;
	}

	public int getPerc() {
		return perc;
	}

}
