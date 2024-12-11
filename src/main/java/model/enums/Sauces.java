package model.enums;

public enum Sauces {
	KETCHUP("Ketchup"),
	MAYONNAISE("Mayonnaise"),
	BBQ("BBQ"),
	YOGURT("Yogurt"),
	TERIYAKI("Teriyaki");
	
	private final String raw;
	
	Sauces(String raw) {
        this.raw = raw;
    }
	
	public String getRaw() {
		return raw;
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
