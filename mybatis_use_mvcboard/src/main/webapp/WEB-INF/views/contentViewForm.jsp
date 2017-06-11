<%@page import="org.springframework.web.bind.annotation.SessionAttributes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <% int bbsID = 0;
if (request.getParameter("bId") != null) {
	bbsID = Integer.parseInt(request.getParameter("bId"));
}

session.setAttribute("content", bbsID);
%> --%>
	
	
			${content.bTitle}<br>
			${content.bContent}<br>
			${content.bName}<br>
<a href="/mybatis/list1">목록으로</a>	

</body>
</html>