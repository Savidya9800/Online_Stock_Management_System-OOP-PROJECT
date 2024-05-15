package net.javaguides.model;

public class User {
	protected int id;
	protected String name;
	protected String address;
	protected String email;
	protected String phone;
	protected String username;
	protected String password;

	public User() {
	}

	public User(String name, String address, String email, String phone, String username, String password) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	public User(int id, String name, String address, String email, String phone, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
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
