package main.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.model.SendMail;
import main.model.Signup;

@WebServlet("/signup")
public class SignupController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");

		Signup su = new Signup();

		String msg = su.signup(id, pw, name, address, phone, email, birthday);

		if (msg.equals("success")) {
			session.setAttribute("signup_success", msg);
			session.setAttribute("enable", id);
			SendMail sendmail=new SendMail();
			sendmail.setTo(email);
			sendmail.setSubject("����K�O�q�v�|���ҥγq��");
			sendmail.setContent(name+" �z�n�A�w�令������K�O�q�v�|���A���I��H�U�s���ҥαz���b��:<br>"+
			"<a href='http://localhost:8080/JavaMovie/userenable'>���I��</a><br>"+
			"���H�󬰨t�Φ۰ʵo�e, �Ф��I��^�ЫH��");
			sendmail.execute();
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(msg.equals("both")){
			session.setAttribute("failed", msg);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}else if(msg.equals("USERID")) {
			session.setAttribute("failed", msg);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}else if(msg.equals("EMAIL")) {
			session.setAttribute("failed", msg);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
