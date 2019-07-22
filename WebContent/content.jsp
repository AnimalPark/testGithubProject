<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<a href="ybbs_list.do">리스트로 돌아가기</a>
		<form method="post" action="ybbs_reply?replyno=${anwser.no}&replygroup=${anwser.groups}">
			<input type="text" name="groups" value="${anwser.groups}" disabled="disabled" /><br />
			작성자: <input type="text" name="name" value="${anwser.name}" disabled="disabled" /><br /> 
			제목: <input type="text" name="subject" value="${anwser.subject}" disabled="disabled" /><br /> 
			내용: <textarea rows="10" cols = "23" name="content" disabled="disabled" >${anwser.content}</textarea>
			<br /> 
			<br />
			<input type="submit"  value="댓글 남기기" />
		</form>
</body>
</html>