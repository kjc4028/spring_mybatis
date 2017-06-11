<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		

<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		
		<c:forEach items="${list1}" var="dto">
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.bName}</td>
			<td>
				<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
				<c:set var="date" value="${dto.bDate}"/>
				<a href="/mybatis/contentView?bId=${dto.bId}">${dto.bTitle}</a></td>
			<td>${fn:substring(date, 0, 4)}년 
			${fn:substring(date, 5, 7)}월
			${fn:substring(date, 8, 10)}일  
			${fn:substring(date, 11, 13)}시
			${fn:substring(date, 14, 16)}분
			</td>
			<td>${dto.bHit}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"> <a href="writeView">글작성</a> </td>
		</tr>
	</table>

</body>
</html>