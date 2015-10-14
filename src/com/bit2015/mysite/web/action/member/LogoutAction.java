package com.bit2015.mysite.web.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();

		if( session == null ) {
			/* 로그인 안하고 로그아웃 요청 */
			WebUtil.redirect( response, "/mysite/main" );
			return;
		}
		
		// 정상적인 로그아웃 처리
		session.removeAttribute( "authUser" );
		session.invalidate();
		
		WebUtil.redirect( response, "/mysite/main" );
	}
}
