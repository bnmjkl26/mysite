package com.bit2015.mysite.web.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.GuestbookDao;
import com.bit2015.mysite.vo.GuestbookVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class DeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String no = request.getParameter( "no" );
		String password = request.getParameter( "password" );
		
		GuestbookVo vo = new GuestbookVo();
		vo.setNo( Long.parseLong( no ) );
		vo.setPassword(password);
		
		GuestbookDao dao = new GuestbookDao();
		dao.delete(vo);
		
		WebUtil.redirect( response, "/mysite/guestbook" );
	}
}
