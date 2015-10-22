package com.bit2015.mysite.web.action.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.MemberDao;
import com.bit2015.mysite.vo.MemberVo;
import com.bit2015.web.action.Action;

public class CheckEmailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		String email = request.getParameter( "email" );
		MemberDao dao = new MemberDao();
		MemberVo vo = dao.get( email );
		
		String json = "{\"result\":\"exist\"}";
		if( vo == null ) {
			json = "{\"result\":\"not exist\"}";
		}
		
		response.setContentType( "application/json; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		out.println( json );
	}

}
