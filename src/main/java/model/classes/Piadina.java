package model.classes;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import model.enums.Dough;
import model.enums.MeatBase;
import model.enums.OptionalElements;
import model.enums.Sauces;

public class Piadina {
	private String name;
	private Dough dough;
	private MeatBase[] meatBase;
	private Sauces[] sauces;
	private OptionalElements[] optionalElements;
	private float price;
	private Employee employee;
	
	public Piadina(
		String name,
		Dough dough,
		MeatBase[] meatBase,
		Sauces[] sauces,
		OptionalElements[] optionalElements,
		float price,
		Employee employee
	) {
        this.name = name;
        this.dough = dough;
        this.meatBase = meatBase;
        this.sauces = sauces;
        this.optionalElements = optionalElements;
        this.price = price;
		this.employee = employee;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	private static final Random RANDOM = new Random();

    public static Piadina random() {
        String name = "Piadina " + (RANDOM.nextInt(1000) + 1);
        Dough dough = Dough.values()[RANDOM.nextInt(Dough.values().length)];
        MeatBase[] meatBase = IntStream.range(0, RANDOM.nextInt(2) + 1).mapToObj(i -> MeatBase.random()).toArray(MeatBase[]::new);
        Sauces[] sauces = IntStream.range(0, RANDOM.nextInt(2) + 1).mapToObj(i -> Sauces.random()).toArray(Sauces[]::new);
        OptionalElements[] optionalElements = IntStream.range(0, RANDOM.nextInt(3) + 1).mapToObj(i -> OptionalElements.random()).toArray(OptionalElements[]::new);
        float price = 5 + RANDOM.nextFloat() * 15;
        Employee employee = Employee.random();

        return new Piadina(name, dough, meatBase, sauces, optionalElements, price, employee);
    }
    
    public static Piadina[] randomList(int size) {
    	return IntStream.range(0, size).mapToObj(i -> random()).toArray(Piadina[]::new);
    }

	@Override
	public String toString() {
		String mBase = Arrays.stream(meatBase).map(MeatBase::getRaw).collect(Collectors.joining(""));
		String sauce = Arrays.stream(sauces).map(Sauces::getRaw).collect(Collectors.joining(""));
		String oElements = Arrays.stream(optionalElements).map(OptionalElements::getRaw).collect(Collectors.joining(""));
		String formattedPrice = String.format("€ %.2f", price);
		
		return "\tName = " + name
			 + "\n\tDough = " + dough.getRaw()
			 + "\n\tMeat base = [" + mBase + "]"
			 + "\n\tSauces = [" + sauce + "]"
			 + "\n\tOptional elements [" + oElements + "]"
			 + "\n\tPrice = " + formattedPrice
			 + "\n\tEmployee = " + employee.getName() + " " + employee.getSurname();
	}
}
