package model.enums;

import java.io.Serializable;

public class Sauces implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String description;
	private double price;
	
	public Sauces(String type, String description, double price) {
        this.type = type;
        this.description = description;
        this.price = price;
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
            new Sauces("Ketchup", "Description", 0.20),
            new Sauces("Mayonnaise", "Description", 0.20),
            new Sauces("BBQ", "Description", 0.30),
            new Sauces("Yogurt", "Description", 0.30),
            new Sauces("Teriyaki", "Description", 0.40)
        };
	}
}
