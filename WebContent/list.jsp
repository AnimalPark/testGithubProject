<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
</head>
<body>
	<c:if test="${empty list}">
		<hr />
		검색된 결과가 존재 하지 않습니다.
		<hr />
	</c:if>
	<a href="ybbs_insert">글쓰기</a>
	<c:if test="${!empty list}">
		<div class="container">
			<table class="table table-hover">
				<tr>
					<td>게시글 번호</td>
					<td>게시글 제목</td>
					<td>이름</td>
					<td>게시날짜</td>
					<td>조회수</td>
				</tr>
				<!-- NO, SUBJECT, CONTENT, NAME, WDATE, VISITED  -->
				<c:forEach var="lists" items="${list}">
					<tr>
						<td>${lists.no}</td>
						<c:if test="${lists.levels eq 0}">
							<td><a
								href="ybbs_read?num=${lists.no}&sessionid=${memberInfo.id}">${lists.subject}</a></td>
						</c:if>
						<c:if test="${lists.levels eq 1}">
							<td><a
								href="ybbs_read?num=${lists.no}&sessionid=${memberInfo.id}">ㄴ${lists.subject}</a></td>
						</c:if>
						<td>${lists.name}</td>
						<td>${lists.wdate}</td>
						<td>${lists.visited}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	${memberInfo.id}
</body>
</html>