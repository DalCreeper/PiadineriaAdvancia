package model.enums;

import java.util.Random;

public enum Dough {
	CLASSIC("Classic", 1.00),
	CHARCOAL("Charcoal", 1.50),
	SAFFRON("Saffron", 1.80),
	WHOLEMEAL("Wholemeal", 1.20),
	GLUTEN_FREE("Gluten free", 1.50);
	
	private final String raw;
	private final double price;
	
	Dough(String raw, double price) {
        this.raw = raw;
        this.price = price;
    }
	
	public String getRaw() {
		return raw;
	}
	
	public double getPrice() {
		return price;
	}
	
	public static Dough random() {
		Random rand = new Random();
		return Dough.values()[rand.nextInt(Dough.values().length)];
	}
	
	public static Dough getEnumText(String text) {
    	switch(text) {
	    	case "Classic" :
	    		return CLASSIC;
	    	case "Charcoal" :
	    		return CHARCOAL;
	    	case "Saffron" :
	    		return SAFFRON;
	    	case "Wholemeal" :
	    		return WHOLEMEAL;
	    	case "Gluten free" :
	    		return GLUTEN_FREE;
			default :
				return CLASSIC;
    	}
    }
}
