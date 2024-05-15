package net.javaguides.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.dao.LoginDAO;
import net.javaguides.model.Login;

@WebServlet("/")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO;

	public void init() {
		loginDAO = new LoginDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Forward the request to dashboard.jsp
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Login loginBean = new Login();

		loginBean.setUsername(username);
		loginBean.setPassword(password);

		try {
			if (loginDAO.validate(loginBean)) {

				response.sendRedirect("dashboard-view");
			} else {
				HttpSession session = request.getSession();

				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}