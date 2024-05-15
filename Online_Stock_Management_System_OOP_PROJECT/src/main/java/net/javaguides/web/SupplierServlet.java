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

import net.javaguides.dao.SupplierDAO;
import net.javaguides.model.Supplier;

@WebServlet("/SupplierServlet")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SupplierDAO supplierDAO;

	public void init() {
		supplierDAO = new SupplierDAO();
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
			case "/newSupplier":
				showNewSupplierForm(request, response);
				break;
			case "/insertSupplier":
				insertSupplier(request, response);
				break;
			case "/deleteSupplier":
				deleteSupplier(request, response);
				break;
			case "/editSupplier":
				showEditSupplierForm(request, response);
				break;
			case "/updateSupplier":
				updateSupplier(request, response);
				break;
			default:
				listSupplier(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	// list Supplier
	private void listSupplier(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Supplier> listSupplier = supplierDAO.selectAllSuppliers(); 
		request.setAttribute("listSupplier", listSupplier);
		RequestDispatcher dispatcher = request.getRequestDispatcher("supplier.jsp");
		dispatcher.forward(request, response);
	}

	// show new supplier form
	private void showNewSupplierForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("supplier-form.jsp");
		dispatcher.forward(request, response);
	}

	// show edit supplier form
	private void showEditSupplierForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Supplier existingSupplier = supplierDAO.selectSupplier(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("supplier-form.jsp");
		request.setAttribute("supplier", existingSupplier);
		dispatcher.forward(request, response);

	}

	// insert supplier
	private void insertSupplier(HttpServletRequest request, HttpServletResponse response)
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

		Supplier newSupplier = new Supplier(name, address, email, phone);
		supplierDAO.insertSupplier(newSupplier);
		this.listSupplier(request, response);
	}

	// update supplier
	private void updateSupplier(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
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

		Supplier updatedSupplier = new Supplier(id, name, address, email, phone);
		supplierDAO.updateSupplier(updatedSupplier);
		this.listSupplier(request, response);
	}

	// delete supplier
	private void deleteSupplier(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String idParam = request.getParameter("id");
		if (idParam != null && !idParam.isEmpty()) {
			try {
				int id = Integer.parseInt(idParam);
				supplierDAO.deleteSupplier(id);
				this.listSupplier(request, response);
			} catch (NumberFormatException e) {
				e.printStackTrace(); // Print the stack trace for debugging purposes
				response.sendRedirect("error.jsp");
			}
		} else {
			response.sendRedirect("error.jsp");
		}
	}
}