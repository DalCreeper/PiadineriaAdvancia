package model.classes;

import java.io.Serializable;
import java.time.Year;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import model.enums.Role;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Set<String> GENERATED_NAMES = new HashSet<>();
	private static final Set<String> GENERATED_SURNAMES = new HashSet<>();
	private static final Set<String> GENERATED_USERNAMES = new HashSet<>();
	private static int COUNTER_NAMES = 1;
	private static int COUNTER_SURNAMES = 1;
	private static int COUNTER_USENAMES = 1;
	
	private String UID;
	private String name;
	private String surname;
	private String username;
	private int yob;
	private Role role;
	
	public Employee(
		String UID,
		String name,
		String surname,
		String username,
		int yob,
		Role role
	) {
		this.UID = UID;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.yob = yob;
        this.role = role;
    }
	
	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getYob() {
		return yob;
	}

	public void setYob(int yob) {
		this.yob = yob;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static Employee random() {
		Random rand = new Random();
		String name;
        do {
            name = "Name " + COUNTER_NAMES++;
        } while (!GENERATED_NAMES.add(name));
        String surname;
        do {
        	surname = "Surname " + COUNTER_SURNAMES++;
        } while (!GENERATED_SURNAMES.add(surname));
        String username;
        do {
        	username = "Username " + COUNTER_USENAMES++;
        } while (!GENERATED_USERNAMES.add(username));
        int currentYear = Year.now().getValue();
        int minYear = currentYear - 100;
        int year = ThreadLocalRandom.current().nextInt(minYear, currentYear + 1);
        Role role = Role.values()[rand.nextInt(Role.values().length)];
		return new Employee(UUID.randomUUID().toString(), name, surname, username, year, role);
	}
	
	@Override
	public String toString() {
		return "\tUID = " + UID
			 + "\n\tName = " + name
			 + "\n\tSurname = " + surname
			 + "\n\tUsername = " + username
			 + "\n\tYob = " + yob
			 + "\n\tRole = " + role.getRaw();
	}
}
