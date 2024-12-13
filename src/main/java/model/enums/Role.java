package model.enums;

import java.util.Random;

public enum Role {
	OWNER("Owner"),
	COOK("Cook"),
	COUNTER_STAFF("Counter Staff"),
	CASHIER("Cashier"),
	WAITER("Waiter"),
	CLEANING_STAFF("Cleaning Staff");
	
	private final String raw;
	
	Role(String raw) {
        this.raw = raw;
    }
	
	public String getRaw() {
		return raw;
	}
	
	public static Role random() {
		Random rand = new Random();
		return Role.values()[rand.nextInt(Role.values().length)];
	}

	public static Role getEnumText(String text) {
    	switch(text) {
	    	case "Owner" :
	    		return OWNER;
	    	case "Cook" :
	    		return COOK;
	    	case "Counter Staff" :
	    		return COUNTER_STAFF;
	    	case "Cashier" :
	    		return CASHIER;
	    	case "Waiter" :
	    		return WAITER;
	    	case "Cleaning Staff" :
	    		return CLEANING_STAFF;
			default :
				return OWNER;
    	}
    }
}
