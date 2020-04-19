package com.javalearning.forward_redirect_demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalearning.objects.Constants;

@WebServlet("/subServlet")
public class SubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public SubServlet() {
		super();
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = (String) request.getAttribute(Constants.ATTRIBUTE_VALUE_KEY);
		
		ServletOutputStream stream = response.getOutputStream();
		stream.println("Test from SubServlet");
		stream.println(value);
	}
}
