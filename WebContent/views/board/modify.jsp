<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/mysite/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
$(function(){
	$( "#board form" ).submit( function(){
		if( $( "input[name='title']" ).val() == "" ) {
			return false;
		}
		if( $( "#board-content" ).val() == "" ) {
			return false;
		}
		
		return true;
	});
});
</script>
</head>
<body>
	<div id="container">
		<c:import url="/views/include/header.jsp"></c:import>
		<div id="content">
			<div id="board">
				<form class="board-form" method="post" action="/mysite/board">
					<input type="hidden" name="a" value="update">
					<input type="hidden" name="no" value="${board.no }">
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글수정</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td><input type="text" name="title" value="${board.title }"></td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<textarea id="board-content" name="content">${board.content }</textarea>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<a href="/mysite/board?a=view&no=${board.no }">취소</a>
						<input type="submit" value="수정">
					</div>
				</form>				
			</div>
		</div>
		<c:import url="/views/include/navigation.jsp"></c:import>
		<c:import url="/views/include/footer.jsp"></c:import>
	</div>
</body>
</html>