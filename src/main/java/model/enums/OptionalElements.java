package model.enums;

import java.util.Random;

public enum OptionalElements {
	MOZZARELLA("Mozzarella", 0.50),
	GHERKINS("Gherkins", 0.30),
	TOMATO("Tomato", 0.40),
	BUFFALO_MOZZARELLA("Buffalo mozzarella", 0.80),
	CRISPY_ONION("Crispy onion", 0.50),
	GREEN_SALAD("Green salad", 0.30),
	RADICCHIO("Radicchio", 0.40),
	ROBIOLA("Robiola", 0.70),
	GALBANINO("Galbanino", 0.60),
	FETA("Feta", 0.80),
	MUSHROOMS("Mushrooms", 0.50),
	GRILLED_AUBERGINES("Grilled aubergines", 0.70),
	GRILLED_COURGETTES("Grilled courgettes", 0.60),
	STEAMED_CARROTS("Steamed carrots", 0.40),
	PHILADELPHIA("Philadelphia", 0.70);
	
	private final String raw;
	private final double price;
	
	OptionalElements(String raw, double price) {
        this.raw = raw;
        this.price = price;
    }
	
	public String getRaw() {
		return raw;
	}
	
	public double getPrice() {
		return price;
	}
	
	public static OptionalElements random() {
		Random rand = new Random();
		return OptionalElements.values()[rand.nextInt(OptionalElements.values().length)];
	}

	public static OptionalElements getEnumText(String text) {
    	switch(text) {
	    	case "Mozzarella" :
	    		return MOZZARELLA;
	    	case "Gherkins" :
	    		return GHERKINS;
	    	case "Tomato" :
	    		return TOMATO;
	    	case "Buffalo mozzarella" :
	    		return BUFFALO_MOZZARELLA;
	    	case "Crispy onion" :
	    		return CRISPY_ONION;
	    	case "Green salad" :
	    		return GREEN_SALAD;
	    	case "Radicchio" :
	    		return RADICCHIO;
	    	case "Robiola" :
	    		return ROBIOLA;
	    	case "Galbanino" :
	    		return GALBANINO;
	    	case "Feta" :
	    		return FETA;
	    	case "Mushrooms" :
	    		return MUSHROOMS;
	    	case "Grilled aubergines" :
	    		return GRILLED_AUBERGINES;
	    	case "Grilled courgettes" :
	    		return GRILLED_COURGETTES;
	    	case "Steamed carrots" :
	    		return STEAMED_CARROTS;
	    	case "Philadelphia" :
	    		return PHILADELPHIA;
			default :
				return MOZZARELLA;
    	}
    }
}
