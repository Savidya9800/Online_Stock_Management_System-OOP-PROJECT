package net.javaguides.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.model.Category;

public class CategoryDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?categories=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Savidya@25";

	private static final String INSERT_CATEGORY_SQL = "INSERT INTO categories" + "  (name, qty, level) VALUES " + " (?, ?, ?);";
	private static final String SELECT_CATEGORY_BY_ID = "select id,name,qty,level from categories where id =?";
	private static final String SELECT_ALL_CATEGORIES = "select * from categories";
	private static final String DELETE_CATEGORIES_SQL = "delete from categories where id = ?;";
	private static final String UPDATE_CATEGORIES_SQL = "update categories set name = ?,qty= ?, level= ? where id = ?;";

	public CategoryDAO() {
	}

	// connection
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// insert Category Details
	public void insertCategory(Category category) throws SQLException {
		System.out.println(INSERT_CATEGORY_SQL);

		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
			preparedStatement.setString(1, category.getName());
			preparedStatement.setInt(2, category.getQty());
			preparedStatement.setInt(3, category.getLevel());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Category selectCategory(int id) {
		Category category = null;
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				int qty = rs.getInt("qty");
				int level = rs.getInt("level");
				category = new Category(id, name, qty, level);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return category;
	}

	//select all category Function
	public List<Category> selectAllCategories() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Category> categories = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES);) {
			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int qty = rs.getInt("qty");
				int level = rs.getInt("level");
				categories.add(new Category(id, name, qty, level));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return categories;
	}

	// delete category
	public boolean deleteCategory(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORIES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// update category
	public boolean updateCategory(Category category) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORIES_SQL);) {
			statement.setString(1, category.getName());
			statement.setInt(2, category.getQty());
			statement.setInt(3, category.getLevel());
			statement.setInt(4, category.getId());

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
