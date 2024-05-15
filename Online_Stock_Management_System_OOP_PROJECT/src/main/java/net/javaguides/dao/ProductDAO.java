package net.javaguides.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.model.Product;

public class ProductDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?products=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Savidya@25";

	private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products" + "  (name, price, qty, category) VALUES " + " (?, ?, ?, ?);";

	private static final String SELECT_PRODUCT_BY_ID = "select id,name,price,qty,category from products where id =?";
	private static final String SELECT_ALL_PRODUCTS = "select * from products";
	private static final String DELETE_PRODUCTS_SQL = "delete from products where id = ?;";
	private static final String UPDATE_PRODUCTS_SQL = "update products set name = ?,price= ?, qty= ?, category =? where id = ?;";

	public ProductDAO() {
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

	// insert Product Details
	public void insertProduct(Product product) throws SQLException {
		System.out.println(INSERT_PRODUCTS_SQL);

		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL)) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setInt(3, product.getQty());
			preparedStatement.setString(4, product.getCategory());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Product selectProduct(int id) {
		Product product = null;
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				Double price = rs.getDouble("price");
				int qty = rs.getInt("qty");
				String category = rs.getString("category");
				product = new Product(id, name, price, qty, category);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return product;
	}

	//select all Products Function
	public List<Product> selectAllProducts() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Product> products = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Double price = rs.getDouble("price");
				int qty = rs.getInt("qty");
				String category = rs.getString("category");
				products.add(new Product(id, name, price, qty, category));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return products;
	}

	// delete Product
	public boolean deleteProduct(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// update Product
	public boolean updateProduct(Product product) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);) {
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setInt(3, product.getQty());
			statement.setString(4, product.getCategory());
			statement.setInt(5, product.getId());

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
