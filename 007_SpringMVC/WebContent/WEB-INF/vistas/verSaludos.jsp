<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>¡Saludos!</h1>
	<h3 style="color:green">${ saludo }</h3>
	<h3 style="color:green">${ persona }</h3>
	<h3 style="color:green">${ persona.nombre }</h3>
	<h3 style="color:green">${ listaSaludos }</h3>
	<a href="verFormularioSaludo">Pincha para volver al formulario</a>
</body>
</html>