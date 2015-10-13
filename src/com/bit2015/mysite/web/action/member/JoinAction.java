package com.bit2015.mysite.web.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.MemberDao;
import com.bit2015.mysite.vo.MemberVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		String name = request.getParameter( "name" );
		String email = request.getParameter( "email" );
		String password = request.getParameter( "password" );
		String gender = request.getParameter( "gender" );
		
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setEmail(email);
		vo.setPassword(password);
		vo.setGender(gender);
		
		MemberDao dao = new MemberDao();
		dao.insert( vo );
		
		WebUtil.redirect(response, "/mysite/member?a=joinsuccess");
	}

}
