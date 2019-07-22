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
		<form method="post" action="ybbs_update?updateno=${anwser.no}">
			작성자: <input type="text" class="form-control" name="name" value="${anwser.name}" disabled="disabled" /><br /> 
			제목: <input type="text" class="form-control" name="subject" value="${anwser.subject}" /><br /> 
			내용: <textarea rows="10" cols = "23" name="content" >${anwser.content}</textarea>
			<br /><br />
			<input type="submit"  value="수정" />
		</form>
		<a href="ybbs_delete?deleteno=${anwser.no}">삭제</a>
</body>
</html>