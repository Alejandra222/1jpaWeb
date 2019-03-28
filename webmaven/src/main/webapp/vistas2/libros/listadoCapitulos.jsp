<%@page import="java.util.List"%>
<%@page import="es.avalon.jpa.negocio.Capitulo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel='stylesheet' type='text/css' href='./css/css1.css'>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js'></script>



</head>
<body>


	<%-- <% List<Capitulo> listaLibros = (List<Capitulo>) request.getAttribute("listaLibros"); %> --%>

	<!-- <h3>Buscador de libros</h3> -->

	<!-- <form action=""> -->
	<!-- <input type="text" name="titulo" placeholder="   Titulo..."> -->
	<!-- <input type="submit" name="aceptar" value="Buscar"> -->
	<!-- <input type="hidden" name="accion" value="buscarTitulo"> -->
	<!-- </form> -->

	<div class="container">
		<h3>Lista de Capitulos</h3>
		<a href='ServletControladorFrontal?accion=formularioInsertarCapitulo&titulo_libro=${param.titulo}'
			class='btn btn-info btn-sm'><span
			class='glyphicon glyphicon-plus'></span> Nuevo</a>

		<table>

			<tr>
				<th><a href="?accion=titulo">Titulo</a></th>
				<th><a href="?accion=autor">Paginas</a></th>
	<th><a href="?accion=libro">Libro</a></th>
			</tr>



			<c:forEach items="${listaCapitulo}" var="capitulo">
				<tr>
					<td>${capitulo.titulo}</td>
					<td>${capitulo.paginas}</td>
					<td>${capitulo.libro.titulo}</td>	
					<th><a
						href="ServletControladorFrontal?accion=borrarCapitulo&titulo=${capitulo.titulo}&libro_titulo=${capitulo.libro.titulo}"
						class='btn btn-warning btn-sm'><span
							class='glyphicon glyphicon-trash'></span> Borrar</a></th>
					<th><a
						href="ServletControladorFrontal?accion=editarCapitulo&titulo=${capitulo.titulo}&libro_titulo=${capitulo.libro.titulo}"
						class='btn btn-primary btn-sm'><span
							class='glyphicon glyphicon-pencil'></span> Editar</a></th>
				</tr>
			</c:forEach>

		</table>
		</br>

		<!-- <a href="ServletControladorCapitulo?accion=formularioInsertar"/>insertar</a> -->
</body>
</html>