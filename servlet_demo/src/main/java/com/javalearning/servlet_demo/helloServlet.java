package com.javalearning.servlet_demo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class helloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String time;
	
    public helloServlet() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		time = LocalDateTime.now().toString();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response, "GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response, "POST");
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response, String method) throws IOException {
		String name = request.getParameter("txtName");
		String msgToClient = processMessageFromClient(name, method);
		
		ServletOutputStream out = response.getOutputStream();
		out.println(msgToClient);
		
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
			
			String msg = String.format("%s: %s", header, request.getHeader(header));
			
			out.println(msg);
		}
		
		out.close();
	}
	
	private String processMessageFromClient(String name, String methodName) {
		return String.format("Hello [%s] at [%s] from [%s]", name, time, methodName);
	}
	 

}
