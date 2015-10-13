<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/views/include/header.jsp"></jsp:include>
		<div id="content">
			<div id="user">
				<p class="jr-success">
					회원가입을 축하합니다.
					<br><br>
					<a href="/mysite/member?a=loginform">로그인하기</a>
				</p>				
			</div>
		</div>
		<jsp:include page="/views/include/navigation.jsp"></jsp:include>
		<jsp:include page="/views/include/footer.jsp"></jsp:include>
	</div>
</body>
</html>