package net.javaguides.model;

public class Supplier {
	protected int id;
	protected String name;
	protected String address;
	protected String email;
	protected String phone;

	public Supplier(String name, String address, String email, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	
	public Supplier(String name) {
		super();
		this.name = name;
	}

	public Supplier(int id, String name, String address, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
