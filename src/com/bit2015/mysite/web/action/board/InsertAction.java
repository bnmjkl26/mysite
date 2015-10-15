package com.bit2015.mysite.web.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2015.mysite.dao.BoardDao;
import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.mysite.vo.MemberVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if( session == null ) {
			WebUtil.redirect( response, "/mysite/main" );
			return;
		}
		MemberVo memberVo = (MemberVo)session.getAttribute( "authUser" );
		
		Long memberNo = memberVo.getNo();
		String title = request.getParameter( "title" );
		String content = request.getParameter( "content" );
		
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent( content );
		vo.setMemberNo( memberNo );
		
		BoardDao dao = new BoardDao();
		dao.insert(vo);
		
		WebUtil.redirect( response, "/mysite/board" );
	}

}
