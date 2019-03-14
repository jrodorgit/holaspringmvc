<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JRODOR - SPRING MVC - HIBERNATE - SPRING SECURITY</title>

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

<script src="<c:url value="/resources/js/global.js"/>"></script>

</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container">
		<div class="row">
			<b>Listado de Permisos.</b>
			<br/>
			<c:forEach items="${lstTP}" var="item">
    		${item}<br>
			</c:forEach>
		</div>
	</div>


	<!--  formulario add tipo permiso -->
	
	<div class="container">
		<b>Alta nuevo Permiso.</b>
		<br/>
		<form action="add" method="post">
			<pre>
				Nombre: <input type="text" name="nombre" value="nombre" />
				descripcion: <input type="text" name="descripcion" value="descripcion" />
				<input type="submit" name="Add Nuevo  Permiso"
					value="Add Nuevo  Permiso" />
			</pre>
			<sec:csrfInput/>
		</form>
	</div>



</body>
</html>