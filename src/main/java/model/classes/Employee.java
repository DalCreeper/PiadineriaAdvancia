package model.classes;

import java.io.Serializable;
import javax.persistence.*;

import model.enums.Role;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
