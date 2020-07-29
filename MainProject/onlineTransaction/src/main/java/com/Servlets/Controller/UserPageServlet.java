package com.Servlets.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Servlets.helper.Validator;

@WebServlet("/userpage.bnk")
public class UserPageServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			request.setAttribute("balance", Validator.getBalance(Validator.UserName));
			request.getRequestDispatcher("/WEB-INF/Views/userPage.jsp").forward(request, response);
		}catch(SQLException e) {
			Validator.dbClosing();
			System.out.println(e.getMessage());
			
		}
		
		catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
