<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!--  creo una variable que me dice si el usuario esta identificado -->
<sec:authorize access="authenticated" var="authenticated" />

<nav class="navbar navbar-inverse navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<a href="<spring:url value="/"/>" class="navbar-brand">JRODOR
				Security Center</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="<spring:url value="/permisos/"/>">Permisos
					Service</a></li>
			<li><a href="<spring:url value="/contact/"/>">Contact</a></li>
			<!--  en funcion de si esta identificado o no mostraremos unas opciones de menu u otras -->
			<c:choose>
				<c:when test="${authenticated}">
					<li>
						<p class="navbar-text">
							Hola
							<sec:authentication property="name" />
							! <a id="idLogout" href="#">Logout</a>
						</p>
						<form id="logout-form" action="<c:url value="/logout/"/>" method="post">
							<sec:csrfInput />
						</form>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="<spring:url value="/login/"/>">Sign In</a></li>
				</c:otherwise>

			</c:choose>

		</ul>
	</div>
</nav>