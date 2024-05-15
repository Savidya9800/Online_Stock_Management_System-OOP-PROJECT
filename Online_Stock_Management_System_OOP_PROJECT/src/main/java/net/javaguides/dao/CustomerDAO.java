package net.javaguides.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.model.Customer;

public class CustomerDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?customers=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Savidya@25";

	private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customers" + "  (name, address, email, phone) VALUES " + " (?, ?, ?, ?);";

	private static final String SELECT_CUSTOMER_BY_ID = "select id,name,address,email,phone from customers where id =?";
	private static final String SELECT_ALL_CUSTOMERS = "select * from customers";
	private static final String DELETE_CUSTOMERS_SQL = "delete from customers where id = ?;";
	private static final String UPDATE_CUSTOMERS_SQL = "update customers set name = ?,address= ?, email= ?, phone =? where id = ?;";

	public CustomerDAO() {
	}

	// connection
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	// insert Customer Details
	public void insertCustomer(Customer customer) throws SQLException {
		System.out.println(INSERT_CUSTOMERS_SQL);

		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL)) {
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getAddress());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getPhone());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Customer selectCustomer(int id) {
		Customer customer = null;
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				customer = new Customer(id, name, address, email, phone);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return customer;
	}

	//select all customers Function
	public List<Customer> selectAllCustomers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Customer> customers = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);) {
			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				customers.add(new Customer(id, name, address, email, phone));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return customers;
	}

	// delete customer
	public boolean deleteCustomer(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// update customer
	public boolean updateCustomer(Customer customer) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMERS_SQL);) {
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getAddress());
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getPhone());
			statement.setInt(5, customer.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
