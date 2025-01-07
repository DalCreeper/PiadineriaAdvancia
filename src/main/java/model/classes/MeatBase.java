package model.classes;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "MEATBASE")
public class MeatBase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private int id;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRICE")
	private double price;
	
	public MeatBase() {}
	
	public MeatBase(int id, String type, String description, double price) {
		this.id = id;
		this.type = type;
        this.description = description;
        this.price = price;
    }
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object o) {
	    if(this == o) return true;
	    if(o == null || getClass() != o.getClass()) return false;
	    MeatBase meatBase = (MeatBase) o;
	    return id == meatBase.id;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id);
	}
}
