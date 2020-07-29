package com.Servlets.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Servlets.helper.Validator;

@WebServlet(urlPatterns = "/transaction.bnk")
public class TransactionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			request.getRequestDispatcher("/WEB-INF/Views/Transaction_view.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String senderName = null;
		String receiverName = null;
		double amount = 0.0;
		
		senderName = request.getParameter("sender");
		receiverName = request.getParameter("receiver");
		amount = Double.parseDouble(request.getParameter("amount"));
		
		
		try {
			if(senderName.equals(receiverName)) {
				request.setAttribute("ErrorMessage", "&#x26A0; You cannot send yourself money");
				request.getRequestDispatcher("/WEB-INF/Views/Transaction_view.jsp").forward(request, response);
			}else {
				
				if(Validator.TransferMoney(senderName,receiverName,amount)) {
					
					request.setAttribute("ErrorMessage", "Transaction Successful");
					request.getRequestDispatcher("/WEB-INF/Views/Transaction_view.jsp").forward(request, response);
				}else {
					request.setAttribute("ErrorMessage", "&#x26A0; For Some Reason We cannot process your request");
					request.getRequestDispatcher("/WEB-INF/Views/Transaction_view.jsp").forward(request, response);
				}
				
			}
		}catch(SQLException e) {
			Validator.dbClosing();
			System.out.println(e.getMessage());
		}
		catch(ServletException | IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
