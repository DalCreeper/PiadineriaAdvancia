package com.advancia.PiadineriaAdvancia.model.classes;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "SAUCES")
public class Sauces implements Serializable {
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
	
	public Sauces() {}
	
	public Sauces(int id, String type, String description, double price) {
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
	    Sauces sauces = (Sauces) o;
	    return id == sauces.id;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id);
	}
}
