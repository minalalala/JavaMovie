package main.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.model.PasswordReset;
import main.model.SendMail;

@WebServlet("/passwordresetsendmail")
public class PasswordResetSendMailController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
//		request.setCharacterEncoding("utf-8");
		SendMail sendmail=new SendMail();
		sendmail.setTo(request.getParameter("email"));
		sendmail.setSubject("����q�v�|���K�X���m");
		sendmail.setContent(" �z�w�ӽбK�X���m�A�ȡA���I��H�U�s�����s�]�m�z���K�X:<br>"+
		"<a href='http://localhost:8080/JavaMovie/password_reset.jsp'>���I��</a><br>"+
		"���H�󬰨t�Φ۰ʵo�e, �Ф��I��^�ЫH��");
		sendmail.execute();
//		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		session.setAttribute("sendmail", "�w�H�H�ܫH�c�A�ЦܫH�c���H�h�ק�K�X");
		request.getRequestDispatcher("password_forget.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
