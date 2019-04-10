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

<link rel='stylesheet' type='text/css' href='../resources/css/css1.css'>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js'></script>



</head>

<body>


	<%-- 	<% List<Capitulo> lista = (List<Capitulo>) request.getAttribute("listaCapitulos"); %> --%>

	<div class="container">
		<div class='row'>

			<h3 align="center" class="titulo">
				Capítulos <span class="glyphicon glyphicon-search"></span>
			</h3>

			<div class='row'>
				<div class='col-xs-4'></div>
				<div class='col-xs-8'>

					<form action="">

						<p>
							<input class='glyphicon glyphicon-trash' type="text"
								name="titulo" placeholder=" título..." /> <input
								type="submit" value="Buscar" class='btn btn-warning'>
						</p>
						
						<input type="hidden" name="libro_titulo"
							value="${param.libro_titulo}"> 
							

						<input type="hidden" name="accion" value="searchCapitulo" />
					</form>

				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class='row'>
			<div class='col-xs-7'>

				<c:choose>
					<c:when test="${param.libro_titulo.equals('')}">
						<h3>
							Lista de <span class="glyphicon glyphicon-list-alt"></span>
						</h3>
					</c:when>

					<c:otherwise>
						<h3>Capítulos del libro: ${param.libro_titulo}</h3>
					</c:otherwise>
				</c:choose>



			</div>

			<div class='col-xs-2 margintop'>
				<c:if test="${!param.libro_titulo.equals('')}">

					<a
						href="formularioInsertar?libro_titulo=${param.libro_titulo}"
						class='colorNuevo'><span class='glyphicon glyphicon-plus'></span>
						Nuevo</a>
				</c:if>
			</div>

			<div class='col-xs-3 margintop'>
				<a href="../libros/lista" class='colorNuevo'><span
					class='glyphicon glyphicon-book'></span> Libros</a>
			</div>
		</div>



		<table>

			<tr>
				<th><a
					href="?accion=ordenarCapitulosPorCampo&filtro=titulo&libro_titulo=${param.libro_titulo}">TÍTULO</a></th>
				<th><a
					href="?accion=ordenarCapitulosPorCampo&filtro=paginas&libro_titulo=${param.libro_titulo}">PÁGINAS</a></th>

				<%-- 		<th>	<a	href="?accion=libro_titulo&filtro=libro_titulo&titulo=<%=request.getParameter("titulo")%>">CAPITULO_LIBRO</a></th> --%>
			</tr>

			<c:forEach items="${listaCapitulo}" var="l">

				<tr>
					<td>${l.titulo}</td>
					<td>${l.paginas}</td>
					<%-- 				<td>${l.libro_titulo}</td> --%>


					<c:if test="${!param.libro_titulo.equals('')}">


						<td><a
							href="borrar&titulo=${l.titulo}&libro_titulo=${param.libro_titulo}"
							class='btn btn-light btn-sm colorBorrar'><span
								class='glyphicon glyphicon-trash'></span> Borrar</a> <a
							href="ServletControladorFrontal?accion=editarCapitulo&titulo=${l.titulo}&libro_titulo=${param.libro_titulo}"
							class='btn btn-light btn-sm colorEditar'><span
								class='glyphicon glyphicon-pencil'></span> Editar</a></td>

					</c:if>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>
