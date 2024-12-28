package model.classes;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "OPTIONAL_ELEMENTS")
public class OptionalElements implements Serializable {
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
	
	public OptionalElements() {}
	
	public OptionalElements(int id, String type, String description, double price) {
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
	    OptionalElements optionalElements = (OptionalElements) o;
	    return id == optionalElements.id;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id);
	}
	
	@Deprecated
	public static OptionalElements[] hardCodedList() {
		return new OptionalElements[] {
            new OptionalElements(1, "Mozzarella", "Description", 0.50),
            new OptionalElements(2, "Gherkins", "Description", 0.30),
            new OptionalElements(3, "Tomato", "Description", 0.40),
            new OptionalElements(4, "Buffalo mozzarella", "Description", 0.80),
            new OptionalElements(5, "Crispy onion", "Description", 0.50),
            new OptionalElements(6, "Green salad", "Description", 0.30),
            new OptionalElements(7, "Radicchio", "Description", 0.40),
            new OptionalElements(8, "Robiola", "Description", 0.70),
            new OptionalElements(9, "Galbanino", "Description", 0.60),
            new OptionalElements(10, "Feta", "Description", 0.80),
            new OptionalElements(11, "Mushrooms", "Description", 0.50),
            new OptionalElements(12, "Grilled aubergines", "Description", 0.70),
            new OptionalElements(13, "Grilled courgettes", "Description", 0.60),
            new OptionalElements(14, "Steamed carrots", "Description", 0.40),
            new OptionalElements(15, "Philadelphia", "Description", 0.70)
        };
	}
}
