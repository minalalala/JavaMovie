package main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import main.model.TicketInfo;
import main.model.TransactionLog;

/**
 * Servlet implementation class BookingController
 */
@WebServlet("/booking")
public class BookingController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String movieId = request.getParameter("movieId");
		String showtime = request.getParameter("showtime");
		String hall = request.getParameter("hall");
		String seats = request.getParameter("seats");
		String types = request.getParameter("types");
		String userId = request.getParameter("userId");
		String transactionNo = "";
		
		//���o�y����
		TransactionLog log = new TransactionLog();
		transactionNo = log.getLastTransactionNo();
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
		String date = formatDate.format(new Date());
		int tmp;
		
		if(transactionNo.equals("") || !date.equals(transactionNo.substring(0, 8))) {
			transactionNo = date+String.format("%04d", 1);
		}else {
			tmp = Integer.parseInt(transactionNo.substring(8, 12))+1;
			transactionNo = date+String.format("%04d", tmp);
		}
		
		//�g�J�������
		if(!log.setLog(transactionNo).equals("false")) {
			
			//�g�J�q������
			TicketInfo info = new TicketInfo();
			String[] typeInfos = types.split(",");
			String[] seat = seats.split(",");
			int s=0;
			for(int i=0; i<typeInfos.length; i++) {
				String[] inftypeInfo = typeInfos[i].split("=");
				String type = inftypeInfo[0].replaceAll("[\\pP\\p{Punct}]","").trim();
				String[] price_counts = inftypeInfo[1].split("_");
				String counts = price_counts[1].replaceAll("[\\pP\\p{Punct}]","");
				
				for(int j=0; j<Integer.parseInt(counts); j++) {
					String[] row_col = seat[s].split("_");
					String row = row_col[0].replaceAll("[\\pP\\p{Punct}]","").trim();
					int col = Integer.parseInt(row_col[1].replaceAll("[\\pP\\p{Punct}]",""));
					
					info.setTicketInfo(movieId, showtime, hall, row, col, type, userId, transactionNo);
					s += 1;
				}
			}
		}else {
			PrintWriter out = response.getWriter();
			out.print("�q������!");
		}
		
		request.setAttribute("transactionNo", transactionNo);
		request.getRequestDispatcher("booking_success.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
