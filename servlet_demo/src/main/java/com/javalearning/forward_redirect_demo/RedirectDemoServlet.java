package com.javalearning.forward_redirect_demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/redirectServlet" }, 
			initParams = {
				@WebInitParam(name="email", value = "tranthenhut@gmail.com")
			}
)
public class RedirectDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirect = request.getParameter("redirect");
		
		if ("yes".equalsIgnoreCase(redirect)) {
			
			//redirect to /subServlet
			String contextPath = request.getContextPath();
			String url = contextPath + "/subServlet";
			
			response.sendRedirect(url);
		}
		else {
			ServletOutputStream stream = response.getOutputStream();
			
			stream.println("Message in RedirectDemoServlet");			
			String email = this.getServletConfig().getInitParameter("email");			
			stream.println("My email is: " + email);
		}
		
	}
}
