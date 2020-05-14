package main.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.model.Login;
import main.model.UserQuery;
import main.tbl_view.UserView;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();

		Login login = new Login();
		String name = login.signin(request.getParameter("USER_ID"), request.getParameter("PASSWORD"));

		if (name!=null) {
			session.setAttribute("login_success", name);
			session.setAttribute("USER_ID", request.getParameter("USER_ID"));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (name==null) {
			session.setAttribute("login_failed", name);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
