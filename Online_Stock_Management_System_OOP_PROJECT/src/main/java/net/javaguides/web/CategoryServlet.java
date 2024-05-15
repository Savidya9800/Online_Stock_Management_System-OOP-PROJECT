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

import net.javaguides.dao.CategoryDAO;
import net.javaguides.model.Category;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;

	public void init() {
		categoryDAO = new CategoryDAO();
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
			case "/newCategory":
				SHOWFORM(request, response);
				break;
			case "/insertCategory":
				INSERT(request, response);
				break;
			case "/deleteCategory":
				DELETE(request, response);
				break;
			case "/editCategory":
				SHOWEDITFORM(request, response);
				break;
			case "/updateCategory":
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

	// default list category
	private void LIST(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Category> listCategory = categoryDAO.selectAllCategories();
		request.setAttribute("listCategory", listCategory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("category.jsp");
		dispatcher.forward(request, response);
	}

	// show new category form
	private void SHOWFORM(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("category-form.jsp");
		dispatcher.forward(request, response);
	}

	// show edit category form
	private void SHOWEDITFORM(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Category existingCategory = categoryDAO.selectCategory(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("category-form.jsp");
		request.setAttribute("category", existingCategory);
		dispatcher.forward(request, response);

	}

	// insert category
	private void INSERT(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = request.getParameter("name");
		int qty;
		try {
			qty = Integer.parseInt(request.getParameter("qty"));
			int level = Integer.parseInt(request.getParameter("level"));
			Category newCategory = new Category(name, qty, level);
			categoryDAO.insertCategory(newCategory);
			this.LIST(request, response);
		} catch (NumberFormatException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}
	// update category
	private void UPDATE(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int qty = Integer.parseInt(request.getParameter("qty"));
		int level = Integer.parseInt(request.getParameter("level"));
		Category updatedCategory = new Category(id, name, qty, level);
		categoryDAO.updateCategory(updatedCategory);
		this.LIST(request, response);
	}

	// delete category
	private void DELETE(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String idParam = request.getParameter("id");
		if (idParam != null && !idParam.isEmpty()) {
			try {
				int id = Integer.parseInt(idParam);
				categoryDAO.deleteCategory(id);
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