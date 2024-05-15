package net.javaguides.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.dao.ProductDAO;
import net.javaguides.model.Product;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;

	public void init() {
		productDAO = new ProductDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/newProduct":
				SHOWFORM(request, response);
				break;
			case "/insertProduct":
				INSERT(request, response);
				break;
			case "/deleteProduct":
				DELETE(request, response);
				break;
			case "/editProduct":
				SHOWEDITFORM(request, response);
				break;
			case "/updateProduct":
				UPDATE(request, response);
				break;
			default:
				LIST(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	// default list Product
	private void LIST(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> listProduct = productDAO.selectAllProducts();
		request.setAttribute("listProduct", listProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
		dispatcher.forward(request, response);
	}

	// show new Product form
	private void SHOWFORM(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
		dispatcher.forward(request, response);
	}

	// show edit Product form
	private void SHOWEDITFORM(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product existingProduct = productDAO.selectProduct(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
		request.setAttribute("product", existingProduct);
		dispatcher.forward(request, response);

	}

	// insert Product
	private void INSERT(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		int qty;
		try {
			qty = Integer.parseInt(request.getParameter("qty"));
			// Quantity is an integer, proceed with insertion
			String category = request.getParameter("category");
			Product newProduct = new Product(name, price, qty, category);
			productDAO.insertProduct(newProduct);
			this.LIST(request, response);

		} catch (NumberFormatException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}

	}

	// update Product
	private void UPDATE(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		String category = request.getParameter("category");
		Product updatedProduct = new Product(id, name, price, qty, category);
		productDAO.updateProduct(updatedProduct);
		this.LIST(request, response);
	}

	// delete Product
	private void DELETE(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String idParam = request.getParameter("id");
		if (idParam != null && !idParam.isEmpty()) {
			try {
				int id = Integer.parseInt(idParam);
				productDAO.deleteProduct(id);
			} catch (NumberFormatException e) {
				// Redirect user to an error page or display an error message
				response.sendRedirect(request.getContextPath() + "/error.jsp");
				return;
			}
		} else {
			// Redirect user to an error page or display an error message
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		}
		// response.sendRedirect(request.getContextPath() + "/");
		this.LIST(request, response);
	}
}