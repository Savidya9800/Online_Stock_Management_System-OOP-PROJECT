package net.javaguides.model;

public class Purchase {
	protected int id;
	protected String products;
	protected String supplier;
	protected int qty;
	protected String date;
	
	public Purchase() {
	}
	
	public Purchase(int id, String products, String supplier, int qty, String date) {
		super();
		this.id = id;
		this.products = products;
		this.supplier = supplier;
		this.qty = qty;
		this.date = date;
	}
	

	public Purchase(String products, String supplier, int qty, String date) {
		super();
		this.products = products;
		this.supplier = supplier;
		this.qty = qty;
		this.date = date;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
