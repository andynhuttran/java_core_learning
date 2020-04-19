package com.javalearning.forward_redirect_demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalearning.objects.Constants;


/*
 * Define servlet by Annotation instead of web.xml
 * 
 * You could define multiple urlPattern 
 */
@WebServlet(urlPatterns = {"/forwardDemo", "/forwardDemoServlet"},
		displayName = "Forward Demo Servlet",
		initParams = {
				@WebInitParam(name="email1", value = "tranthenhut@gmail.com"),
				@WebInitParam(name="email2", value = "cole.nhut.tran@gmail.com"),
		},
		description = "forward allows only to the pages in the website, use request.setAttribute to tranfer data"
		)
public class ForwardDemoServlet extends HttpServlet {
	
	private static final long serialVersionUID = -2734707623136730923L;

	
	public ForwardDemoServlet() {
		super();
	}
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = request.getParameter("forward");
		
		if ("yes".equals(forward)) { //forward to another servlet to process data
			request.setAttribute(Constants.ATTRIBUTE_VALUE_KEY, "Message from ForwardDemoServlet");
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/subServlet");
			dispatcher.forward(request, response);
		}
		else {
			ServletOutputStream stream = response.getOutputStream();
			stream.println("Text from ForwardDemoServlet");
			
			stream.println("- Servlet path: " + request.getServletPath());
			stream.println("- Server name: " + request.getServerName());
		}
	}
	
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
