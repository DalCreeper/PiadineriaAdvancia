package model.enums;

public enum Dough {
	CLASSIC("Classic"),
	CHARCOAL("Charcoal"),
	SAFFRON("Saffron"),
	WHOLEMEAL("Wholemeal"),
	GLUTEN_FREE("Gluten free");
	
	private final String raw;
	
	Dough(String raw) {
        this.raw = raw;
    }
	
	public String getRaw() {
		return raw;
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
