package net.javaguides.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.model.Purchase;
import net.javaguides.model.Supplier;

public class PurchaseDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?purchase_products=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Savidya@25";

	private static final String INSERT_PURCHASE_SQL = "INSERT INTO purchase_products" + "  (products, supplier, qty, date) VALUES "
			+ " (?, ?, ?, ?);";
	private static final String SELECT_PURCHASE_BY_ID = "select id,products,supplier,qty,date from purchase_products where id =?";
	private static final String SELECT_ALL_PRODUCTS = "select * from purchase_products";
	private static final String DELETE_PRODUCTS_SQL = "delete from purchase_products where id = ?;";
	private static final String UPDATE_PRODUCTS_SQL = "update purchase_products set products = ?,supplier= ?, qty= ?, date =? where id = ?;";
	private static final String SELECT_SUPPLIER_NAME = "select name from suppliers";

	public PurchaseDAO() {
	}

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
	//insert Purchase Products
	public void insertPurchase(Purchase purchase) throws SQLException {
		System.out.println(INSERT_PURCHASE_SQL);
		
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PURCHASE_SQL)) {
			preparedStatement.setString(1, purchase.getProducts());
			preparedStatement.setString(2, purchase.getSupplier());
			preparedStatement.setInt(3, purchase.getQty());
			preparedStatement.setString(4, purchase.getDate());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Purchase selectPurchase(int id) {
		Purchase purchase = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PURCHASE_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String products = rs.getString("products");
				String supplier = rs.getString("supplier");
				int qty = rs.getInt("qty");
				String date = rs.getString("date");
				purchase = new Purchase(id, products, supplier, qty, date);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return purchase;
	}

	public List<Purchase> selectAllPurchases() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Purchase> purchases = new ArrayList<>();

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
				String products = rs.getString("products");
				String supplier = rs.getString("supplier");
				int qty = rs.getInt("qty");
				String date = rs.getString("date");
				purchases.add(new Purchase(id, products, supplier, qty, date));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return purchases;
	}

	// delete Purchase Products
	public boolean deletePurchase(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// update Purchase Products
	public boolean updatePurchase(Purchase purchase) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);) {
			statement.setString(1, purchase.getProducts());
			statement.setString(2, purchase.getSupplier());
			statement.setInt(3, purchase.getQty());
			statement.setString(4, purchase.getDate());
			statement.setInt(5, purchase.getId());

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
	
	//Select Supplier Name - Purchase Form 
	public List<Supplier> selectSupplierName() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Supplier> Suppliers = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SUPPLIER_NAME);) {
			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				Suppliers.add(new Supplier(name));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Suppliers;
	}

}
