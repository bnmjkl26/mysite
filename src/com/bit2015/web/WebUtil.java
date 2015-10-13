package com.bit2015.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	public static void forwarding(HttpServletRequest request,
			HttpServletResponse response, String path) 
			throws ServletException,
			IOException {
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}
	
	public static void redirect( HttpServletResponse response, String url )
		throws ServletException, IOException {
		response.sendRedirect( url );
	}
	
}
