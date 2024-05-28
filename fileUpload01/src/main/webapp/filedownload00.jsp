<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="filedownload01.jsp">
		<input type=hidden name="param1" value="saltbread.jpg" /><br>
		<input type=hidden name="param2" value="financier.jpg" /><br>
		<input type="submit" value="이미지 다운로드">
	</form>
</body>
</html>