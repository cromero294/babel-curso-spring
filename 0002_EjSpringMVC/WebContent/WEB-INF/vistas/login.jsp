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
	<form action="altaUsuario" method="post">
		Usuario: <input type="text" name="user"/>
		Password: <input type="password" name="password"/>
		<input type="submit" value="Entrar"/>
	</form>
	<p style="color:red">${ mensaje }</p>
</body>
</html>