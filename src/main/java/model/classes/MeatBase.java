package model.classes;

import java.io.Serializable;
import java.util.Objects;

public class MeatBase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String type;
	private String description;
	private double price;
	
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
	
	public static MeatBase[] hardCodedList() {
		return new MeatBase[] {
            new MeatBase(1, "Cooked ham", "Description", 0.90),
            new MeatBase(2, "Raw ham", "Description", 1.20),
            new MeatBase(3, "Salami", "Description", 1.00),
            new MeatBase(4, "Speck", "Description", 1.10),
            new MeatBase(5, "Lard", "Description", 0.80),
            new MeatBase(6, "Beef", "Description", 1.50),
            new MeatBase(7, "Turkey", "Description", 1.00),
            new MeatBase(8, "Chicken", "Description", 0.90),
            new MeatBase(9, "Bacon", "Description", 1.10),
            new MeatBase(10, "Pork", "Description", 1.20)
        };
	}
}
