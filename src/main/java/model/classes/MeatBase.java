package model.classes;

import java.io.Serializable;

public class MeatBase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String description;
	private double price;
	
	public MeatBase(String type, String description, double price) {
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
	
	public static MeatBase[] hardCodedList() {
		return new MeatBase[] {
            new MeatBase("Cooked ham", "Description", 0.90),
            new MeatBase("Raw ham", "Description", 1.20),
            new MeatBase("Salami", "Description", 1.00),
            new MeatBase("Speck", "Description", 1.10),
            new MeatBase("Lard", "Description", 0.80),
            new MeatBase("Beef", "Description", 1.50),
            new MeatBase("Turkey", "Description", 1.00),
            new MeatBase("Chicken", "Description", 0.90),
            new MeatBase("Bacon", "Description", 1.10),
            new MeatBase("Pork", "Description", 1.20)
        };
	}
}
