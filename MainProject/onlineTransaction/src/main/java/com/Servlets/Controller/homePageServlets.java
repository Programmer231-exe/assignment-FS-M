package com.Servlets.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Servlets.helper.Validator;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/homepage.bank")
public class homePageServlets extends HttpServlet {
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.getRequestDispatcher("/WEB-INF/Views/homepage.jsp").forward(request,response);
		} catch (ServletException | IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		processRequest(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		String UserName = null;
		String password = null;
		
		
		UserName = request.getParameter("username");
		password = request.getParameter("password");
		
		
		try {
			Validator.getConnection();
			if(Validator.isValid(UserName,password)) {
				Validator.UserName = UserName;
				request.getSession().setAttribute("userName", UserName);
				response.sendRedirect("/userpage.bnk");
			}else {
				
				request.setAttribute("Error" ,"&#x26A0; Username or Password in Invalid");
				request.getRequestDispatcher("/WEB-INF/Views/homepage.jsp").forward(request,response);
			}
			
			}catch(SQLException e) {
				Validator.dbClosing();
				System.out.println(e.getMessage());
				
			} catch (ServletException | IOException e) {
				System.out.println(e.getMessage());
			}
		
		
	}

}
