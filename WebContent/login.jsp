<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<form action = "login" method = "post">
		<input type = "text" name = "id" placeholder="아이디를 입력하세요." /><br />
		<input type = "password" name = "pwd" placeholder="비밀번호를 입력하세요." /><br />
		<input type = "submit" value = "로그인하기"/>
	</form>
	
	<p>체크용 : </p>
	<p>${memberInfo}</p>
	<p>${msg}</p>
</body>
</html>