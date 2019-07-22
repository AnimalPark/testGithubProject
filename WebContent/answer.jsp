<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ybbs_content" method = "post">
		<input type = "hidden" id = "id" name = "id" value = "${memberInfo.id}" />
		작성자: <input type="text" id = "name" name = "name"  value="${memberInfo.name}" disabled="disabled" /><br />
		제목 <input type="text" name="subject" />
		<br />
		<br /> 
		내용 <textarea rows="10" cols = "23" name="comment"></textarea>
		<input type="submit" value="등록" />
	</form>
</body>
</html>