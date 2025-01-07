package model.classes;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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
	private Set<MeatBase> meatBase;
	
	@ManyToMany
    @JoinTable(
        name = "PIADINA_SAUCES",
        joinColumns = @JoinColumn(name = "PIADINA_ID"),
        inverseJoinColumns = @JoinColumn(name = "SAUCES_ID")
    )
	private Set<Sauces> sauces;
	
	@ManyToMany
    @JoinTable(
        name = "PIADINA_OPTIONAL_ELEMENTS",
        joinColumns = @JoinColumn(name = "PIADINA_ID"),
        inverseJoinColumns = @JoinColumn(name = "OPTIONAL_ELEMENTS_ID")
    )
	private Set<OptionalElements> optionalElements;
	
	@Column(name = "PRICE")
	private double price;
	
	@ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;
	
	public Piadina() {}
	
	public Piadina(
		String name,
		Dough dough,
		Set<MeatBase> meatBase,
		Set<Sauces> sauces,
		Set<OptionalElements> optionalElements,
		double price,
		Employee employee
	) {
        this.name = name;
        this.dough = dough;
        this.meatBase = meatBase != null ? meatBase : new HashSet<>();
        this.sauces = sauces != null ? sauces : new HashSet<>();
        this.optionalElements = optionalElements != null ? optionalElements : new HashSet<>();
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
	
	public Set<MeatBase> getMeatBase() {
		return meatBase;
	}

	public void setMeatBase(Set<MeatBase> meatBase) {
		this.meatBase = meatBase;
	}

	public Set<Sauces> getSauces() {
		return sauces;
	}

	public void setSauces(Set<Sauces> sauces) {
		this.sauces = sauces;
	}

	public Set<OptionalElements> getOptionalElements() {
		return optionalElements;
	}

	public void setOptionalElements(Set<OptionalElements> optionalElements) {
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
	
	public void addMeatBase(MeatBase meatBase) {
		this.meatBase.add(meatBase);
	}

	public void addSauces(Sauces sauce) {
		this.sauces.add(sauce);
	}
	
	public void addOptionalElement(OptionalElements optionalElement) {
		this.optionalElements.add(optionalElement);
	}

	private String formatCollection(Set<?> set) {
        return set.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

	@Override
	public String toString() {
	    return "\n\t\tName = " + name
	        + "\n\t\tDough = " + dough.getType()
	        + "\n\t\tMeat base = [" + formatCollection(meatBase) + "]"
	        + "\n\t\tSauces = [" + formatCollection(sauces) + "]"
	        + "\n\t\tOptional elements = [" + formatCollection(optionalElements) + "]"
	        + "\n\t\tPrice = " + String.format("€ %.2f", price)
	        + "\n\t\tEmployee = " + employee.getName() + " " + employee.getSurname();
	}
}
