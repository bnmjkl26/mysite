package com.bit2015.mysite.web.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.BoardDao;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		Long no = new Long( request.getParameter( "no" ) );
		
		BoardDao dao = new BoardDao();
		dao.delete( no );
		
		WebUtil.redirect(response, "/mysite/board");
	}
}
