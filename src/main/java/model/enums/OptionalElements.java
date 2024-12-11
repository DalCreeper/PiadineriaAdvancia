package model.enums;

public enum OptionalElements {
	MOZZARELLA("Mozzarella"),
	GHERKINS("Gherkins"),
	TOMATO("Tomato"),
	BUFFALO_MOZZARELLA("Buffalo mozzarella"),
	CRISPY_ONION("Crispy onion"),
	GREEN_SALAD("Green salad"),
	RADICCHIO("Radicchio"),
	ROBIOLA("Robiola"),
	GALBANINO("Galbanino"),
	FETA("Feta"),
	MUSHROOMS("Mushrooms"),
	GRILLED_AUBERGINES("Grilled aubergines"),
	GRILLED_COURGETTES("Grilled courgettes"),
	STEAMED_CARROTS("Steamed carrots"),
	PHILADELPHIA("Philadelphia");
	
	private final String raw;
	
	OptionalElements(String raw) {
        this.raw = raw;
    }
	
	public String getRaw() {
		return raw;
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
