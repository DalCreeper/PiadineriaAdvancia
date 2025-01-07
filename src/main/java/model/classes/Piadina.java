package model.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

@Entity
@Table(name = "PIADINA")
public class Piadina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@ManyToOne
    @JoinColumn(name = "DOUGH_ID")
	private Dough dough;
	
	@ManyToMany
    @JoinTable(
        name = "PIADINA_MEATBASE",
        joinColumns = @JoinColumn(name = "PIADINA_ID"),
        inverseJoinColumns = @JoinColumn(name = "MEATBASE_ID")
    )
	private List<MeatBase> meatBase;
	
	@ManyToMany
    @JoinTable(
        name = "PIADINA_SAUCES",
        joinColumns = @JoinColumn(name = "PIADINA_ID"),
        inverseJoinColumns = @JoinColumn(name = "SAUCES_ID")
    )
	private List<Sauces> sauces;
	
	@ManyToMany
    @JoinTable(
        name = "PIADINA_OPTIONAL_ELEMENTS",
        joinColumns = @JoinColumn(name = "PIADINA_ID"),
        inverseJoinColumns = @JoinColumn(name = "OPTIONAL_ELEMENTS_ID")
    )
	private List<OptionalElements> optionalElements;
	
	@Column(name = "PRICE")
	private double price;
	
	@ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;
	
	public Piadina() {}
	
	public Piadina(
		int id,
		String name,
		Dough dough,
		List<MeatBase> meatBase,
		List<Sauces> sauces,
		List<OptionalElements> optionalElements,
		double price,
		Employee employee
	) {
		this.id = id;
        this.name = name;
        this.dough = dough;
        this.meatBase = meatBase != null ? meatBase : new ArrayList<>();
        this.sauces = sauces != null ? sauces : new ArrayList<>();
        this.optionalElements = optionalElements != null ? optionalElements : new ArrayList<>();
        this.price = price;
		this.employee = employee;
    }
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dough getDough() {
		return dough;
	}
	
	public void setDough(Dough dough) {
		this.dough = dough;
	}
	
	public List<MeatBase> getMeatBase() {
		return meatBase;
	}

	public void setMeatBase(List<MeatBase> meatBase) {
		this.meatBase = meatBase;
	}

	public List<Sauces> getSauces() {
		return sauces;
	}

	public void setSauces(List<Sauces> sauces) {
		this.sauces = sauces;
	}

	public List<OptionalElements> getOptionalElements() {
		return optionalElements;
	}

	public void setOptionalElements(List<OptionalElements> optionalElements) {
		this.optionalElements = optionalElements;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public List<MeatBase> addMeatBase(MeatBase meatBase) {
	    if(this.meatBase == null) {
	        this.meatBase = new ArrayList<>();
	    }
	    this.meatBase.add(meatBase);
	    return this.meatBase;
	}

	public List<Sauces> addSauces(Sauces sauces) {
	    if(this.sauces == null) {
	    	this.sauces = new ArrayList<>();
	    }
	    this.sauces.add(sauces);
	    return this.sauces;
	}
	
	public List<OptionalElements> addOptionalElement(OptionalElements optionalElements) {
	    if(this.optionalElements == null) {
	        this.optionalElements = new ArrayList<>();
	    }
	    this.optionalElements.add(optionalElements);
	    return this.optionalElements;
	}

	private String formatList(List<?> list) {
	    return list.stream().map(Object::toString).collect(Collectors.joining(", "));
	}

	@Override
	public String toString() {
	    return "\n\t\tName = " + name
	        + "\n\t\tDough = " + dough.getType()
	        + "\n\t\tMeat base = [" + formatList(meatBase) + "]"
	        + "\n\t\tSauces = [" + formatList(sauces) + "]"
	        + "\n\t\tOptional elements = [" + formatList(optionalElements) + "]"
	        + "\n\t\tPrice = " + String.format("€ %.2f", price)
	        + "\n\t\tEmployee = " + employee.getName() + " " + employee.getSurname();
	}
}
