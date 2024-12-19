package model.utils;

import model.enums.ConsoleType;

@Deprecated
public class ConsoleUtils {
	private static String sys() {
		return "[SYSTEM] ";
	}
	
	private static String err() {
		return "[ERROR] ";
	}
	
	private static String fat() {
		return "[FATAL_ERROR] ";
	}
	
	private static String war() {
		return "[WARNING] ";
	}
	
	private static String deb() {
		return "[DEBUG] ";
	}
	
	public static void print(String type, String value, Object T) {
		ConsoleType typeEnum = ConsoleType.getEnumText(type);
		switch(typeEnum) {
			case SYSTEM : System.out.println(sys() + value + " = " + T); break;
			case ERROR : System.out.println(err() + value + " = " + T); break;
			case FATAL_ERROR : System.out.println(fat() + value + " = " + T); break;
			case WARNING : System.out.println(war() + value + " = " + T); break;
			case DEBUG : System.out.println(deb() + value + " = " + T); break;
		}
	}
	
	public static void print(String type, String value) {
		ConsoleType typeEnum = ConsoleType.getEnumText(type);
		switch(typeEnum) {
			case SYSTEM : System.out.println(sys() + value); break;
			case ERROR : System.out.println(err() + value); break;
			case FATAL_ERROR : System.out.println(fat() + value); break;
			case WARNING : System.out.println(war() + value); break;
			case DEBUG : System.out.println(deb() + value); break;
		}
	}
}
