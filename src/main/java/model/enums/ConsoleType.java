package model.enums;

public enum ConsoleType {
	SYSTEM("S"),
	ERROR("E"),
	FATAL_ERROR("F"),
	WARNING("W"),
	DEBUG("D");
	
	private final String shortcut;
	
	ConsoleType(String shortcut) {
        this.shortcut = shortcut;
    }
	
	public String getShortcut() {
		return shortcut;
	}

	public static ConsoleType getEnumText(String text) {
    	switch(text) {
	    	case "S" :
	    		return SYSTEM;
	    	case "E" :
	    		return ERROR;
	    	case "F" :
	    		return FATAL_ERROR;
	    	case "W" :
	    		return WARNING;
	    	case "D" :
	    		return DEBUG;
			default :
				return DEBUG;
    	}
    }
}
