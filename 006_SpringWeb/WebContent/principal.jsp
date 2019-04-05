<%@ page import="modelo.entidades.Mensaje" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Esto se llama scriplets -->
	<%
		String s = "";
		String nombre = (String)session.getAttribute("nombre");
		Mensaje m = new Mensaje();
	%>
	
	<h1><%=nombre%></h1> <!-- Con el = pegamos en el html -->
	<h1>${nombre}</h1>
	
	<p align="center">
		<font color="red">
			<a href="ScopesServlet">Refresh</a>
		</font>
	</p>
	
	<table>
		<tr>
			<td>Prototipo 1</td>
			<td>${mprototype1}</td>
		</tr>
		<tr>
			<td>Prototipo 2</td>
			<td>${mprototype2}</td>
		</tr>
		<tr>
			<td>Request 1</td>
			<td>${mrequest1}</td>
		</tr>
		<tr>
			<td>Request 2</td>
			<td>${mrequest2}</td>
		</tr>
		<tr>
			<td>Session</td>
			<td>${msession}</td>
		</tr>
		<tr>
			<td>Singleton</td>
			<td>${msingleton}</td>
		</tr>
	</table>
</body>
</html>