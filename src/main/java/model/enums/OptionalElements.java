package model.enums;

import java.io.Serializable;

public class OptionalElements implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String description;
	private double price;
	
	public OptionalElements(String type, String description, double price) {
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

	public static OptionalElements[] hardCodedList() {
		return new OptionalElements[] {
            new OptionalElements("Mozzarella", "Description", 0.50),
            new OptionalElements("Gherkins", "Description", 0.30),
            new OptionalElements("Tomato", "Description", 0.40),
            new OptionalElements("Buffalo mozzarella", "Description", 0.80),
            new OptionalElements("Crispy onion", "Description", 0.50),
            new OptionalElements("Green salad", "Description", 0.30),
            new OptionalElements("Radicchio", "Description", 0.40),
            new OptionalElements("Robiola", "Description", 0.70),
            new OptionalElements("Galbanino", "Description", 0.60),
            new OptionalElements("Feta", "Description", 0.80),
            new OptionalElements("Mushrooms", "Description", 0.50),
            new OptionalElements("Grilled aubergines", "Description", 0.70),
            new OptionalElements("Grilled courgettes", "Description", 0.60),
            new OptionalElements("Steamed carrots", "Description", 0.40),
            new OptionalElements("Philadelphia", "Description", 0.70)
        };
	}
}
