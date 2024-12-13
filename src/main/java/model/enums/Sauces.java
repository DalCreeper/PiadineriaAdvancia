package model.enums;

import java.util.Random;

public enum Sauces {
	KETCHUP("Ketchup", 0.20),
	MAYONNAISE("Mayonnaise", 0.20),
	BBQ("BBQ", 0.30),
	YOGURT("Yogurt", 0.30),
	TERIYAKI("Teriyaki", 0.40);
	
	private final String raw;
	private final double price;
	
	Sauces(String raw, double price) {
        this.raw = raw;
        this.price = price;
    }
	
	public String getRaw() {
		return raw;
	}
	
	public double getPrice() {
		return price;
	}
	
	public static Sauces random() {
		Random rand = new Random();
		return Sauces.values()[rand.nextInt(Sauces.values().length)];
	}

	public static Sauces getEnumText(String text) {
    	switch(text) {
	    	case "Ketchup" :
	    		return KETCHUP;
	    	case "Mayonnaise" :
	    		return MAYONNAISE;
	    	case "BBQ" :
	    		return BBQ;
	    	case "Yogurt" :
	    		return YOGURT;
	    	case "Teriyaki" :
	    		return TERIYAKI;
			default :
				return KETCHUP;
    	}
    }
}
