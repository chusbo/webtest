<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>이 파일은 first_include.jsp 입니다.</h3>
	<jsp:include page="second_include.jsp" flush="false" />
	<p>Jakarta Server Page</p>
</body>
</html>