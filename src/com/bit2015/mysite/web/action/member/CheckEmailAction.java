package com.bit2015.mysite.web.action.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

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

		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "result", "ok" );

		if( vo == null ) {
			map.put( "data", true );  // 사용 가능한 경우
		} else {
			map.put( "data", false );
		}

		JSONObject jsonObject = JSONObject.fromObject( map );
		
		response.setContentType( "application/json; charset=UTF-8" );
		PrintWriter out = response.getWriter();
		out.println( jsonObject.toString() );
	}

}
