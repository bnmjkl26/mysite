package com.bit2015.mysite.web.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class DeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String no = request.getParameter( "no" );
		//request.setAttribute( "no", no );
		WebUtil.forwarding( request, response, "/views/guestbook/deleteform.jsp" );
	}

}
