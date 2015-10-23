<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/views/include/header.jsp"></c:import>
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
					<c:set var='count' value='${fn:length(list) }' />				
					<c:forEach items='${list }' var='vo' varStatus='status'>
						<tr>
							<td>${count-status.index }</td>
							<td><a href="/mysite/board?a=view&no=${vo.no }">${vo.title }</a></td>
							<td>${vo.memberName }</td>
							<td>${vo.viewCount }</td>
							<td>${vo.regDate }</td>
							<td>
								<c:choose>
									<c:when test='${authUser.no == vo.memberNo }'>									
										<a href="/mysite/board?a=delete&no=${vo.no }" class="del">삭제</a>
									</c:when>
									<c:otherwise>
										&nbsp;
									</c:otherwise>
								</c:choose>										
							</td>
						</tr>
					</c:forEach>
				</table>
				<div class="bottom">
					<c:if test='${not empty authUser }'>
						<a href="/mysite/board?a=write" id="new-book">글쓰기</a>
					</c:if>
				</div>				
			</div>
		</div>
		<c:import url="/views/include/navigation.jsp"></c:import>
		<c:import url="/views/include/footer.jsp"></c:import>
	</div>
</body>
</html>