<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello there!</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h4 class="center-align">Failure!</h4>
<h5 class="center-align">${errormsg}</h5>
<jsp:include page="footer.jsp"/>
</body>
</html>
