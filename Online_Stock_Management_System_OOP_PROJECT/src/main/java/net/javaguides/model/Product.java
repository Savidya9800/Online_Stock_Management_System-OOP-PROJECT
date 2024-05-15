package net.javaguides.model;

public class Product {
	protected int id;
	protected String name;
	protected double price;
	protected int qty;
	protected String category;
	
	public Product(String name, double price, int qty, String category) {
		super();
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.category = category;
	}

	public Product(int id, String name, double price, int qty, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.category = category;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
