package model.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Piadina implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Set<String> GENERATED_NAMES = new HashSet<>();
	private static int COUNTER = 1;
	
	private int id;
	private String name;
	private Dough dough;
	private List<MeatBase> meatBase;
	private List<Sauces> sauces;
	private List<OptionalElements> optionalElements;
	private double price;
	private Employee employee;
	
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
	
	@Deprecated
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
        List<MeatBase> meatBase = new ArrayList<>();
        meatBase.add(new MeatBase(1, m1, "Description", m1p));
        meatBase.add(new MeatBase(2, m2, "Description", m2p));
        List<Sauces> sauces = new ArrayList<>();
        sauces.add(new Sauces(1, s1, "Description", s1p));
        sauces.add(new Sauces(2, s2, "Description", s2p));
        List<OptionalElements> optionalElements = new ArrayList<>();
        optionalElements.add(new OptionalElements(1, o1, "Description", o1p));
        optionalElements.add(new OptionalElements(2, o2, "Description", o2p));
        optionalElements.add(new OptionalElements(3, o3, "Description", o3p));
        double price = dough.getPrice()
        	    + meatBase.stream().mapToDouble(MeatBase::getPrice).sum()
        	    + sauces.stream().mapToDouble(Sauces::getPrice).sum()
        	    + optionalElements.stream().mapToDouble(OptionalElements::getPrice).sum();
        Employee employee = Employee.random();

        return new Piadina(id, name, dough, meatBase, sauces, optionalElements, price, employee);
    }
    
	@Deprecated
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
