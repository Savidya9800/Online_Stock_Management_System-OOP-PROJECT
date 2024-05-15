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

import net.javaguides.dao.PurchaseDAO;
import net.javaguides.model.Purchase;
import net.javaguides.model.Supplier;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PurchaseDAO purchaseDAO;

	public void init() {
		purchaseDAO = new PurchaseDAO();
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
			case "/newPurchase":
				showNewForm(request, response);
				break;
			case "/insertPurchase":
				insertPurchase(request, response);
//				showNewForm(request, response);
				break;
			case "/deletePurchase":
				deletePurchase(request, response);
				break;
			case "/editPurchase":
				showEditForm(request, response);
				break;
			case "/updatePurchase":
				updatePurchase(request, response);
				break;
			default:
				listPurchase(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	// list purchase
	private void listPurchase(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Purchase> listPurchase = purchaseDAO.selectAllPurchases();
		request.setAttribute("listPurchase", listPurchase);
		RequestDispatcher dispatcher = request.getRequestDispatcher("purchase.jsp");
		dispatcher.forward(request, response);
	}

	// show new purchase form
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Read supplier Name
		List<Supplier> listPurchase = purchaseDAO.selectSupplierName();
		request.setAttribute("listPurchase", listPurchase);

		RequestDispatcher dispatcher = request.getRequestDispatcher("purchase-form.jsp");
		dispatcher.forward(request, response);
	}

	// show edit purchase form
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Purchase existingPurchase = purchaseDAO.selectPurchase(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("purchase-form.jsp");
		request.setAttribute("purchase", existingPurchase);
		dispatcher.forward(request, response);
	}

	// insert purchase product
	private void insertPurchase(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String products = request.getParameter("products");
		String supplier = request.getParameter("supplier");
		try {
			int qty = Integer.parseInt(request.getParameter("qty"));
			String date = request.getParameter("date");
			Purchase newPurchase = new Purchase(products, supplier, qty, date);
			purchaseDAO.insertPurchase(newPurchase);
			this.listPurchase(request, response);
		} catch (NumberFormatException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}

	// update purchase product
	private void updatePurchase(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String products = request.getParameter("products");
		String supplier = request.getParameter("supplier");
		int qty = Integer.parseInt(request.getParameter("qty"));
		String date = request.getParameter("date");
		Purchase book2 = new Purchase(id, products, supplier, qty, date);
		purchaseDAO.updatePurchase(book2);
		this.listPurchase(request, response);
	}

	// delete purchase product
	private void deletePurchase(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		purchaseDAO.deletePurchase(id);
		this.listPurchase(request, response);
	}
}
