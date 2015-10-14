<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.bit2015.mysite.vo.BoardVo"%>
<%@ page import="com.bit2015.mysite.vo.MemberVo" %>
<%
	MemberVo authUser = (MemberVo)session.getAttribute( "authUser" );
	BoardVo vo = ( BoardVo )request.getAttribute( "board" ); 
%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/views/include/header.jsp" flush="false"></jsp:include>
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td><%=vo.getTitle() %></td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
							<%=vo.getContent().replaceAll( "\n", "<br>" ) %>	
							</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="/mysite/board">글목록</a>
					<%
						if( authUser != null && authUser.getNo() == vo.getMemberNo() ) {
					%>
						<a href="/mysite/board?a=modify&no=<%=vo.getNo() %>">글수정</a>
					<%
						}
					%>
				</div>
			</div>
		</div>
		<jsp:include page="/views/include/navigation.jsp" flush="false"></jsp:include>
		<jsp:include page="/views/include/footer.jsp" flush="false"></jsp:include>
	</div>
</body>
</html>