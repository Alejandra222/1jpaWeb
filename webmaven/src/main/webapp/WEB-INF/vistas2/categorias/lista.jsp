<%@page import="java.util.List"%>
<%@page import="es.avalon.jpa.negocio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel='stylesheet' type='text/css' href='../resources/css/css1.css'>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js'></script>
</head>
<body>




	<%-- 	<% List<Libro> listaLibros = (List<Libro>) request.getAttribute("listaLibros"); %> --%>

	<div class="container">
		<div class='row'>

			<h3 align="center" class="titulo">
				Categorias <span class="glyphicon glyphicon-search"></span>
			</h3>

			<div class='row'>
				<div class='col-xs-4'></div>
				<div class='col-xs-8'>

					<form action="search">

						<p>
							<input class='glyphicon glyphicon-trash' type="text"
								name="titulo" placeholder=" título..." /> <input type="submit"
								value="Buscar" class='btn btn-warning'>

						</p>
						<input type="hidden" name="accion" value="searchLibro" />
					</form>

				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class='row'>
			<div class='col-xs-7'>
				<h3>
					Lista de <span class="glyphicon glyphicon-folder-open"></span>
				</h3>
			</div>

			<div class='col-xs-2 margintop'>
				<a href="formularioInsertar" class='colorNuevo'><span
					class='glyphicon glyphicon-plus'></span> Nuevo</a>
			</div>

			<div class='col-xs-3 margintop'>
				<a href="../libros/lista" class='colorNuevo'><span
					class='glyphicon glyphicon-book'></span> Libros</a>
			</div>
		</div>



		<table>

			<tr>
				<th><a href="ordenarCampos?campo=titulo">ID</a></th>
				<th><a href="ordenarCampos?campo=autor">NOMBRE</a></th>

			</tr>



			<c:forEach items="${listaLibros}" var="l">

				<tr>
					<td>${l.id}</td>
					<td>${l.nombre}</td>

					<%-- 			<td><a href="borrar?titulo=${l.titulo}" class='btn btn-light btn-sm colorBorrar'><span class='glyphicon glyphicon-trash'></span>     Borrar</a></td> --%>
					<%-- 			<td><a href="editarFormulario?titulo=${l.titulo}" class='btn btn-light btn-sm colorEditar'><span class='glyphicon glyphicon-pencil'></span>     Editar</a></td> --%>
					<td><a
						href="verLibrosPorCategoria?id=${l.id}&nombre=${l.nombre}"
						class='btn btn-light btn-sm colorIrCapitulo'><span
							class='glyphicon glyphicon-eye-open'></span> Ver libros</a></td>

				</tr>


			</c:forEach>

		</table>

	</div>
</body>
</html>