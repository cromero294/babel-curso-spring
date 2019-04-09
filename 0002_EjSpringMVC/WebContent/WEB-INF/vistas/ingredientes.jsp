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
	<form action="pedirPizza" method="post">
		Nombre: <input type="text" name="nombre"/></br>
		Direccion: <input type="text" name="direccion"/></br>
		<strong>Tamaño:</strong> Pequeña <input type="radio" name="tam" value="small" checked/> Mediana <input type="radio" name="tam" value="small"/> Grande <input type="radio" name="tam" value="small"/></br>
		<strong>Ingredientes:</strong> </br>
		Masa <input type="checkbox" name="ingredientes" value="masa" checked/></br>
		Aceitunas <input type="checkbox" name="ingredientes" value="aceitunas"/></br>
		Bollicaos <input type="checkbox" name="ingredientes" value="bollicaos"/></br>
		Queso <input type="checkbox" name="ingredientes" value="queso"/></br>
		
		<input type="submit" value="Add pizza"/>
	</form>
	
	<form action="compraFinal" method="get">
		<input type="submit" value="Comprar"/>
	</form>
</body>
</html>