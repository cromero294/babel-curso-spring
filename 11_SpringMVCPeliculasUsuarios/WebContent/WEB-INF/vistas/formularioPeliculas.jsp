<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function accionFormulario(accion){
		var formulario = document.getElementById("formulario");
		formulario.action = accion;
	}
</script>
</head>
<body>
	<h1 align="center">
		Formulario Peliculas
	</h1>

	<form:form id="formulario" method="post" modelAttribute="pelicula">
		<form:hidden path="id"/>
		<table align="center">
			<tr>
				<td>Titulo</td>
				<td><form:input path="titulo"></form:input></td>
				<td></td>
			</tr>
			<tr>
				<td>Genero</td>
				<td><form:input path="genero"></form:input></td>
				<td></td>
			</tr>
			<tr>
				<td>Year</td>
				<td><form:input path="year"></form:input></td>
				<td></td>
			</tr>
		</table>
		<input type="submit" onclick="accionFormulario('insertar')" 
			value="Alta Pelicula">
		<input type="submit" onclick="accionFormulario('modificar')" 
			value="Modificar Pelicula"/>
		<input type="submit" onclick="accionFormulario('borrar')"
			value="Borrar Pelicula"/>
		<input type="submit" onclick="accionFormulario('verListado')"
			value="Volver"/>
	</form:form>

	<h1 style="color:red">${errores }</h1>
</body>
</html>




