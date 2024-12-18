package model.classes;

import java.io.Serializable;

public class Dough implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String type;
	private String description;
	private double price;
	
	public Dough(int id, String type, String description, double price) {
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
	
	public static Dough[] hardCodedList() {
		return new Dough[] {
            new Dough(1, "Classic", "Description", 1.00),
            new Dough(2, "Charcoal", "Description", 1.50),
            new Dough(3, "Saffron", "Description", 1.80),
            new Dough(4, "Wholemeal", "Description", 1.20),
            new Dough(5, "Gluten free", "Description", 1.50)
        };
	}
}
