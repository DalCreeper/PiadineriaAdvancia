package model.classes;

import java.util.Random;

public class Employee {
	private String name;
	private String surname;
	
	public Employee(
		String name,
		String surname
	) {
        this.name = name;
        this.surname = surname;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public static Employee random() {
		Random rand = new Random();
		return new Employee("Nome" + rand.nextInt(10), "Cognome" + rand.nextInt(10));
	}
	
	@Override
	public String toString() {
		return "\tName = " + name
			 + "\n\tSurname = " + surname;
	}
}
