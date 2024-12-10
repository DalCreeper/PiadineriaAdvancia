package model.utils;

import model.enums.ConsoleType;

public class ConsoleUtils {
	private static String sys() {
		return "\n[SYSTEM] ";
	}
	
	private static String err() {
		return "\n[ERROR] ";
	}
	
	private static String war() {
		return "\n[WARNING] ";
	}
	
	private static String deb() {
		return "\n[DEBUG] ";
	}
	
	public static void print(String type, String value, Object T) {
		ConsoleType typeEnum = ConsoleType.getEnumText(type);
		switch(typeEnum) {
			case SYSTEM : System.out.println(sys() + value + " = " + T); break;
			case ERROR : System.out.println(err() + value + " = " + T); break;
			case WARNING : System.out.println(war() + value + " = " + T); break;
			case DEBUG : System.out.println(deb() + value + " = " + T); break;
		}
	}
	
	public static void print(String type, String value) {
		ConsoleType typeEnum = ConsoleType.getEnumText(type);
		switch(typeEnum) {
			case SYSTEM : System.out.println(sys() + value); break;
			case ERROR : System.out.println(err() + value); break;
			case WARNING : System.out.println(war() + value); break;
			case DEBUG : System.out.println(deb() + value); break;
		}
	}
}
