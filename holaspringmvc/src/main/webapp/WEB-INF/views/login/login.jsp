<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kevin's Auto Service Center</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest Jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
	type="text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container">
		<div class="row">
			<h1>Login Form</h1>
		</div>
		<c:url value="/login" var="loginVar"/>
		<form id="login-form" action="${loginVar}" method="POST">
			<div class="form-group">
				<label for="make">Username</label>
				<input name="custom_username" class="form-control" />
			</div>
			<div class="form-group">
				<label for="model">Password</label>
				<input type="password" name="custom_password" class="form-control" />
			</div>
			<c:if test="${param.error != null}">
			<p>Usuario NO valido.</p>
			</c:if>
			<c:if test="${param.logout != null}">
			<p>Hasta luego!</p>
			</c:if>
			<button type="submit" id="btn-save" class="btn btn-primary">Login</button>
			<sec:csrfInput/>
		</form>
	</div>
</body>
</html>