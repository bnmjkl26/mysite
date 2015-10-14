<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.bit2015.mysite.vo.BoardVo" %>
<%@ page import="com.bit2015.mysite.vo.MemberVo" %>
<%
	MemberVo authUser = (MemberVo)session.getAttribute( "authUser" );
	List<BoardVo> list = (List<BoardVo>)request.getAttribute( "list" );
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
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>				
					<%
						int totalCount = list.size();
						int index = 0;
						for( BoardVo vo : list ) {
					%>
					<tr>
						<td><%=totalCount-index-- %></td>
						<td><a href="mysite/board?a=view&no=<%=vo.getNo() %>"><%=vo.getTitle() %></a></td>
						<td><%=vo.getMemberName() %></td>
						<td><%=vo.getViewCount() %></td>
						<td><%=vo.getRegDate() %></td>
						<td>
							<%
								if( authUser != null && authUser.getNo() == vo.getMemberNo() ) {
							%>
								<a href="/mysite/board?a=delete&no=<%=vo.getNo() %>" class="del">삭제</a>
							<% 
								} else {
							%>
								&nbsp;
							<% 
								}
							%>
						</td>
					</tr>
					<%
						}
					%>
				</table>
				<div class="bottom">
					<%
						if( authUser != null ) {
					%>
						<a href="" id="new-book">글쓰기</a>
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