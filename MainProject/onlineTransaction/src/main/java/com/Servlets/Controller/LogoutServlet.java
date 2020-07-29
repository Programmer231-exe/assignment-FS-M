package com.Servlets.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Servlets.helper.Validator;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/logout.bnk")

public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// parameter is what is passed between browser and servlet

		// to transfer parameter to jsp

		request.getSession().invalidate();
		Validator.dbClosing();
		response.sendRedirect("/homepage.bank");
		

	}
}
