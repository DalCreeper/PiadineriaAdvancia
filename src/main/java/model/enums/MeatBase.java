package model.enums;

import java.util.Random;

public enum MeatBase {
	COOKED_HAM("Cooked ham", 0.90),
	RAW_HAM("Raw ham", 1.20),
	SALAMI("Salami", 1.00),
	SPECK("Speck", 1.10),
	LARD("Lard", 0.80),
	BEEF("Beef", 1.50),
	TURKEY("Turkey", 1.00),
	CHICKEN("Chicken", 0.90),
	BACON("Bacon", 1.10),
	PORK("Pork", 1.20);
	
	private final String raw;
	private final double price;
	
	MeatBase(String raw, double price) {
        this.raw = raw;
        this.price = price;
    }
	
	public String getRaw() {
		return raw;
	}
	
	public double getPrice() {
		return price;
	}
	
	public static MeatBase random() {
		Random rand = new Random();
		return MeatBase.values()[rand.nextInt(MeatBase.values().length)];
	}

	public static MeatBase getEnumText(String text) {
    	switch(text) {
	    	case "Cooked ham" :
	    		return COOKED_HAM;
	    	case "Raw ham" :
	    		return RAW_HAM;
	    	case "Salami" :
	    		return SALAMI;
	    	case "Speck" :
	    		return SPECK;
	    	case "Lard" :
	    		return LARD;
	    	case "Beef" :
	    		return BEEF;
	    	case "Turkey" :
	    		return TURKEY;
	    	case "Chicken" :
	    		return CHICKEN;
	    	case "Bacon" :
	    		return BACON;
	    	case "Pork" :
	    		return PORK;
			default :
				return COOKED_HAM;
    	}
    }
}
