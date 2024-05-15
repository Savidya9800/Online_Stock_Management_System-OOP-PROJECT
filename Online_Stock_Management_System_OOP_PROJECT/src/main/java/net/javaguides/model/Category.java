package net.javaguides.model;

public class Category {
	protected int id;
	protected String name;
	protected int qty;
	protected int level;
	
	public Category(String name, int qty, int level) {
		super();
		this.name = name;
		this.qty = qty;
		this.level = level;
	}

	public Category(int id, String name, int qty, int level) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.level = level;
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
