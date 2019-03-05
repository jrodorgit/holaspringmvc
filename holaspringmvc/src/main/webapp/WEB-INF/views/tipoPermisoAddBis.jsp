<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mi titulo aqui...</title>
</head>
<body>
<!-- Mensaje -->
<%=request.getAttribute("msg") %>
<br/>


<!--  formulario add tipo permiso -->
<form action="addTipoPermisoBis" method="post">
<pre>
Nombre: <input type="text" name="nombre" value="nombre permiso" />
descripcion: <input type="text" name="descripcion" value="descripcion del permiso" />
<input type="submit" name="Add Nuevo Tipo Permiso" value="Add Nuevo Tipo Permiso"/>
</pre>
</form>

</body>
</html>