package model.classes;

import java.io.Serializable;
import java.time.Year;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.*;

import model.enums.Role;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Set<String> GENERATED_NAMES = new HashSet<>();
	private static final Set<String> GENERATED_SURNAMES = new HashSet<>();
	private static final Set<String> GENERATED_USERNAMES = new HashSet<>();
	private static int COUNTER_NAMES = 1;
	private static int COUNTER_SURNAMES = 1;
	private static int COUNTER_USENAMES = 1;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private int UID;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "SURNAME", nullable = false)
	private String surname;
	
	@Column(name = "USERNAME", nullable = false, unique = true)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "YOB", nullable = false)
	private int yob;
	
	@Column(name = "ROLE", nullable = false)
    private String roleRaw;
	
	@Transient
	private Role role;
	
	public Employee() {}
	
	public Employee(
		int UID,
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
	
	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
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
        if(role == null && roleRaw != null) {
            role = Role.getEnumText(roleRaw);
        }
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
        this.roleRaw = role != null ? role.getRaw() : null;
    }
	
	@Deprecated
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
		return new Employee(1, name, surname, username, year, role);
	}
	
	@Override
	public String toString() {
		return "\tUID = " + UID
			 + "\n\tName = " + name
			 + "\n\tSurname = " + surname
			 + "\n\tUsername = " + username
			 + "\n\tPassword = " + password
			 + "\n\tYob = " + yob
			 + "\n\tRole = " + role.getRaw();
	}
}
