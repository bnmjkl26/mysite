package com.bit2015.mysite.web.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.BoardDao;
import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long no = new Long( request.getParameter( "no" ) );
		
		// 게시물 가져오기
		BoardDao dao = new BoardDao();
		BoardVo vo = dao.get( no );
		
		request.setAttribute( "board", vo );
		WebUtil.forwarding(request, response, "/views/board/modify.jsp");
	}

}
