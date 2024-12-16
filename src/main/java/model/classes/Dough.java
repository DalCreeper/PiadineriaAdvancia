package model.classes;

import java.io.Serializable;

public class Dough implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String description;
	private double price;
	
	public Dough(String type, String description, double price) {
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
	
	public static Dough[] hardCodedList() {
		return new Dough[] {
            new Dough("Classic", "Description", 1.00),
            new Dough("Charcoal", "Description", 1.50),
            new Dough("Saffron", "Description", 1.80),
            new Dough("Wholemeal", "Description", 1.20),
            new Dough("Gluten free", "Description", 1.50)
        };
	}
}
