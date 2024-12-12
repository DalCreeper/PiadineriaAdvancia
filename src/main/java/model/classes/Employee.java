package model.classes;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Set<String> GENERATED_NAMES = new HashSet<>();
	private static final Set<String> GENERATED_SURNAMES = new HashSet<>();
	private static int COUNTER_NAMES = 1;
	private static int COUNTER_SURNAMES = 1;
	
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
		String name;
        do {
            name = "Name " + COUNTER_NAMES++;
        } while (!GENERATED_NAMES.add(name));
        String surname;
        do {
        	surname = "Surname " + COUNTER_SURNAMES++;
        } while (!GENERATED_SURNAMES.add(surname));
		return new Employee(name, surname);
	}
	
	@Override
	public String toString() {
		return "\tName = " + name
			 + "\n\tSurname = " + surname;
	}
}
