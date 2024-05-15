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

import net.javaguides.dao.CustomerDAO;
import net.javaguides.model.Customer;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;

	public void init() {
		customerDAO = new CustomerDAO();
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
			case "/new":
				SHOWFORM(request, response);
				break;
			case "/insert":
				INSERT(request, response);
				break;
			case "/delete":
				DELETE(request, response);
				break;
			case "/edit":
				SHOWEDITFORM(request, response);
				break;
			case "/update":
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

	// default list Customer
	private void LIST(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Customer> listCustomer = customerDAO.selectAllCustomers();
		request.setAttribute("listCustomer", listCustomer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer.jsp");
		dispatcher.forward(request, response);
	}

	// show new customer form
	private void SHOWFORM(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer-form.jsp");
		dispatcher.forward(request, response);
	}

	// show edit customer form
	private void SHOWEDITFORM(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Customer existingCustomer = customerDAO.selectCustomer(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer-form.jsp");
		request.setAttribute("customer", existingCustomer);
		dispatcher.forward(request, response);

	}

	// insert customer
	private void INSERT(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		// Email validation
		if (!email.contains("@")) {
			// Redirect user to an error page or display an error message
			response.sendRedirect(request.getContextPath() + "/error2.jsp");
			return;
		}

		Customer newCustomer = new Customer(name, address, email, phone);
		customerDAO.insertCustomer(newCustomer);
		this.LIST(request, response);
	}

	// update customer
	private void UPDATE(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Customer updatedCustomer = new Customer(id, name, address, email, phone);
		customerDAO.updateCustomer(updatedCustomer);
		this.LIST(request, response);
	}

	// delete customer
	private void DELETE(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String idParam = request.getParameter("id");
		if (idParam != null && !idParam.isEmpty()) {
			try {
				int id = Integer.parseInt(idParam);
				customerDAO.deleteCustomer(id);
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
		this.LIST(request, response);
	}
}