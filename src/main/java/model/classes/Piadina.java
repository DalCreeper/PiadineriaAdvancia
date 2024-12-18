package model.classes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Piadina implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Set<String> GENERATED_NAMES = new HashSet<>();
	private static int COUNTER = 1;
	
	private int id;
	private String name;
	private Dough dough;
	private MeatBase[] meatBase;
	private Sauces[] sauces;
	private OptionalElements[] optionalElements;
	private double price;
	private Employee employee;
	
	public Piadina(
		int id,
		String name,
		Dough dough,
		MeatBase[] meatBase,
		Sauces[] sauces,
		OptionalElements[] optionalElements,
		double price,
		Employee employee
	) {
		this.id = id;
        this.name = name;
        this.dough = dough;
        this.meatBase = meatBase;
        this.sauces = sauces;
        this.optionalElements = optionalElements;
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
	public MeatBase[] getMeatBase() {
		return meatBase;
	}

	public void setMeatBase(MeatBase[] meatBase) {
		this.meatBase = meatBase;
	}

	public Sauces[] getSauces() {
		return sauces;
	}

	public void setSauces(Sauces[] sauces) {
		this.sauces = sauces;
	}

	public OptionalElements[] getOptionalElements() {
		return optionalElements;
	}

	public void setOptionalElements(OptionalElements[] optionalElements) {
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
	
    public static Piadina hardCoded(
    		int id,
    		String d1,
    		double d1p,
    		String m1,
    		double m1p,
    		String m2,
    		double m2p,
    		String s1,
    		double s1p,
    		String s2,
    		double s2p,
    		String o1,
    		double o1p,
    		String o2,
    		double o2p,
    		String o3,
    		double o3p
	) {
    	String name;
        do {
            name = "Piadina " + COUNTER++;
        } while (!GENERATED_NAMES.add(name));
        Dough dough = new Dough(1, d1, "Description", d1p);
        MeatBase[] meatBase = {
    		new MeatBase(1, m1, "Description", m1p),
    		new MeatBase(2, m2, "Description", m2p)
		};
        Sauces[] sauces = {
    		new Sauces(1, s1, "Description", s1p),
    		new Sauces(2, s2, "Description", s2p)
        };
        OptionalElements[] optionalElements = {
    		new OptionalElements(1, o1, "Description", o1p),
    		new OptionalElements(2, o2, "Description", o2p),
    		new OptionalElements(3, o3, "Description", o3p)
        };
        double price = dough.getPrice();
        for(MeatBase meat : meatBase) {
            price += meat.getPrice();
        }
        for(Sauces sauce : sauces) {
            price += sauce.getPrice();
        }
        for(OptionalElements optional : optionalElements) {
            price += optional.getPrice();
        }
        Employee employee = Employee.random();

        return new Piadina(id, name, dough, meatBase, sauces, optionalElements, price, employee);
    }
    
    public static Piadina[] hardCodedList() {
    	Piadina p1 = hardCoded(
			1,
			"Classic", 1.00,
			"Cooked ham", 0.90,
			"Raw ham", 1.20,
			"Ketchup", 0.20,
			"Mayonnaise", 0.20,
			"Mozzarella", 0.50,
			"Gherkins", 0.30,
			"Tomato", 0.40
		);
    	Piadina p2 = hardCoded(
			2,
			"Charcoal", 1.50,
			"Salami", 1.00,
			"Speck", 1.10,
			"BBQ", 0.30,
			"Yogurt", 0.30,
			"Buffalo mozzarella", 0.80,
			"Crispy onion", 0.50,
			"Green salad", 0.30
		);
    	Piadina p3 = hardCoded(
			3,
			"Saffron", 1.80,
			"Lard", 0.80,
			"Beef", 1.50,
			"Ketchup", 0.20,
			"Teriyaki", 0.40,
			"Radicchio", 0.40,
			"Robiola", 0.70,
			"Galbanino", 0.60
		);
    	
    	return new Piadina[] {p1, p2, p3};
    }

	@Override
	public String toString() {
		String mBase = Arrays.stream(meatBase).map(MeatBase::getType).collect(Collectors.joining(", "));
		String sauce = Arrays.stream(sauces).map(Sauces::getType).collect(Collectors.joining(", "));
		String oElements = Arrays.stream(optionalElements).map(OptionalElements::getType).collect(Collectors.joining(", "));
		String formattedPrice = String.format("€ %.2f", price);
		
		return "\n\t\tName = " + name
			 + "\n\t\tDough = " + dough.getType()
			 + "\n\t\tMeat base = [" + mBase + "]"
			 + "\n\t\tSauces = [" + sauce + "]"
			 + "\n\t\tOptional elements [" + oElements + "]"
			 + "\n\t\tPrice = " + formattedPrice
			 + "\n\t\tEmployee = " + employee.getName() + " " + employee.getSurname();
	}
}
