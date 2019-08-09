<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h4 class="center-align">${emp}</h4><br>
<jsp:include page="footer.jsp"/>
</body>
</html>