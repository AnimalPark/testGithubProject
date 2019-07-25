<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>

<h1>실험</h1>
	<ul>
		<li><a href="login_input">로그인</a>
	</ul>
	<p>${memberInfo}</p>

	<c:if test="${memberInfo != null}">
		<form action="logout">
			<input type="submit" value="로그아웃하기" />
		</form>
	</c:if>
 
<%-- 	<%
		if (session.getAttribute("memberInfo") != null) {
	%>
	<form action="logout">
		<input type="submit" value="로그아웃하기" />
	</form>
	<%
		}
	%>
	 --%>
	<h2>필러테스트</h2>
	<ul>
		<li><a href = "public">누구나 볼 수 있는 페이지요청</a></li>
		<li><a href = "private.do">로그인한 사람만 볼 수 있는 페이지요청</a></li>
		<li><a href = "private/test.do">로그인한 사람만 볼 수 있는 페이지요청</a></li>
	</ul>
	
	<a href = "ybbs_list.do">답변게시판 이동하기</a>
	<a href = "page_print?page=1">답변게시판 이동하기</a>
	<br />
	<a href = "page_print?page=1">1</a>
	<a href = "page_print?page=2">2</a>
	<a href = "page_print?page=3">3</a>
	<a href = "page_print?page=4">4</a>
	<a href = "page_print?page=5">5</a>
</body>
</html>