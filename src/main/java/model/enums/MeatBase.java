package model.enums;

import java.util.Random;

public enum MeatBase {
	COOKED_HAM("Cooked ham"),
	RAW_HAM("Raw ham"),
	SALAMI("Salami"),
	SPECK("Speck"),
	LARD("Lard"),
	BEEF("Beef"),
	TURKEY("Turkey"),
	CHICKEN("Chicken"),
	BACON("Backon"),
	PORK("Pork");
	
	private final String raw;
	
	MeatBase(String raw) {
        this.raw = raw;
    }
	
	public String getRaw() {
		return raw;
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
	    	case "Backon" :
	    		return BACON;
	    	case "Pork" :
	    		return PORK;
			default :
				return COOKED_HAM;
    	}
    }
}
