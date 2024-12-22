package model.classes;

import java.util.List;

public class PiadinaDeserialize {
	private String name;
	private int dough;
	private List<Integer> meatBase;
	private List<Integer> sauces;
	private List<Integer> optionalElements;
	private double price;
	private String user;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDough() {
		return dough;
	}

	public void setDough(int dough) {
		this.dough = dough;
	}

	public List<Integer> getMeatBase() {
		return meatBase;
	}

	public void setMeatBase(List<Integer> meatBase) {
		this.meatBase = meatBase;
	}

	public List<Integer> getSauces() {
		return sauces;
	}

	public void setSauces(List<Integer> sauces) {
		this.sauces = sauces;
	}

	public List<Integer> getOptionalElements() {
		return optionalElements;
	}

	public void setOptionalElements(List<Integer> optionalElements) {
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
