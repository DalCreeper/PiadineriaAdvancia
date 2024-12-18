package model.classes;

import java.io.Serializable;

public class Sauces implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String type;
	private String description;
	private double price;
	
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

	public static Sauces[] hardCodedList() {
		return new Sauces[] {
            new Sauces(1, "Ketchup", "Description", 0.20),
            new Sauces(2, "Mayonnaise", "Description", 0.20),
            new Sauces(3, "BBQ", "Description", 0.30),
            new Sauces(4, "Yogurt", "Description", 0.30),
            new Sauces(5, "Teriyaki", "Description", 0.40)
        };
	}
}
