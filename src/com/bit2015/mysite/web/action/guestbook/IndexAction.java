package com.bit2015.mysite.web.action.guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.GuestbookDao;
import com.bit2015.mysite.vo.GuestbookVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// default(idnex) action
		GuestbookDao dao= new GuestbookDao();
		List<GuestbookVo> list = dao.getList();

		request.setAttribute( "list", list );
		WebUtil.forwarding( request, response, "/views/guestbook/list.jsp" );		
	}

}
