<%@page import="com.bit2015.mysite.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	MemberVo vo = (MemberVo)session.getAttribute( "authUser" );
%>
		<div id="header">
			<h1>MySite</h1>
			<ul>
				<%
					if( vo == null ) {
				%>
				<li><a href="/mysite/member?a=loginform">로그인</a><li>
				<li><a href="/mysite/member?a=joinform">회원가입</a><li>
				<%
					} else {
				%>
				<li><a href="">회원정보수정</a><li>
				<li><a href="">로그아웃</a><li>
				<li><%=vo.getName() %>님 안녕하세요 ^^;</li>
				<%
					}
				%>
			</ul>
		</div>