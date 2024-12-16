package model.classes;

import java.util.List;

public class PiadinaDeserialize {
	private String name;
	private String dough;
	private List<String> meatBase;
	private List<String> sauces;
	private List<String> optionalElements;
	private double price;
	private String user;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDough() {
		return dough;
	}

	public void setDough(String dough) {
		this.dough = dough;
	}

	public List<String> getMeatBase() {
		return meatBase;
	}

	public void setMeatBase(List<String> meatBase) {
		this.meatBase = meatBase;
	}

	public List<String> getSauces() {
		return sauces;
	}

	public void setSauces(List<String> sauces) {
		this.sauces = sauces;
	}

	public List<String> getOptionalElements() {
		return optionalElements;
	}

	public void setOptionalElements(List<String> optionalElements) {
		this.optionalElements = optionalElements;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
