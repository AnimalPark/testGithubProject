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
 	<p1>황호영 왔다갑니다.</p1>
	<c:if test="${empty list}">
		<hr />
		검색된 결과가 존재 하지 않습니다.
		<hr />
	</c:if>
	<c:if test="${!empty list}">
		<div class="container">
			<p>${current} 번째 게시판</p>
			<table class="table table-hover">
				<tr>
					<td>게시글 번호</td>
					<td>게시글 제목</td>
					<td>아이디</td>
					<td>게시날짜</td>
					<td>조회수</td>
				</tr>
				<!-- NO, SUBJECT, CONTENT, NAME, WDATE, VISITED  -->
				<c:forEach var="lists" items="${list}">
					<tr>
						<td>${lists.no}</td>
						<td><a
							href="ybbs_read?num=${lists.no}&sessionid=${memberInfo.id}">${lists.subject}</a></td>
						<td>${lists.id}</td>
						<td>${lists.wdate}</td>
						<td>${lists.visited}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	<div class="container">
		<c:if test="${start ne 1}">
			<a href="page_print?page=${start-1}">◁</a>
		</c:if>
		<c:if test="${max >= end}">
			<c:forEach var="i" begin="${start}" end="${end}">
				<c:if test="${current eq i}">
					<a href="page_print?page=${i}">[${i}]</a>
				</c:if>
				<c:if test="${current ne i}">
					<a href="page_print?page=${i}">${i}</a>
				</c:if>
			</c:forEach>
			<a href="page_print?page=${end+1}">▷</a>
		</c:if>
		<c:if test="${max < end}">
			<c:forEach var="i" begin="${start}" end="${max}">
				<c:if test="${current eq i}">
					<a href="page_print?page=${i}">[${i}]</a>
				</c:if>
				<c:if test="${current ne i}">
					<a href="page_print?page=${i}">${i}</a>
				</c:if>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>