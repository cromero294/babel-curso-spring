<%@ page import="entidades.Pizza" %>
<%@ page import="entidades.Pedido" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pizzeria Pizza Rica</title>
</head>
<body>
	<h1>¡Bienvenido a Pizzeria Pizza Rica!</h1>
	
	<p>Pedido de ${ nombre }</p>
    <p>Precio: ${ precio }</p>
	
	<form action="login">
		<input type="submit" value="Comprar"/>
	</form>
</body>
</html>