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
<%=request.getAttribute("tp") %>

<!--  formulario add tipo permiso -->
<form action="/tipoPermiso/addBis" method="post">
<pre>
Id: <input type="text" name="id" value="id"/>
Nombre: <input type="text" name="nombre" value="nombre" />
descripcion: <input type="text" name="descripcion" value="nombre" />
<input type="submit" name="Add Nuevo Tipo Permiso" value="Add Nuevo Tipo Permiso"/>
</pre>
</form>

</body>
</html>