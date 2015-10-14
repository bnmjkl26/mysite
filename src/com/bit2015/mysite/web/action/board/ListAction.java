package com.bit2015.mysite.web.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.BoardDao;
import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.getList();
		
		request.setAttribute( "list", list );
		WebUtil.forwarding( request, response, "/views/board/list.jsp" );
	}
}