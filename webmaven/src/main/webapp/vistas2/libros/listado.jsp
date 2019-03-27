<%@page import="java.util.List"%>
<%@page import="es.avalon.jpa.negocio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel='stylesheet' type='text/css' href='./css/css1.css'>
	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>
	<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
		<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js'></script>
</head>
<body>

<%-- 	<% List<Libro> listaLibros = (List<Libro>) request.getAttribute("listaLibros");%> --%>

<h3>Buscador de libros</h3>

<form action="">
<input type="text" name="titulo" placeholder="   Titulo...">
<input type="submit" name="aceptar" value="Buscar">
<input type="hidden" name="accion" value="buscarTitulo">
</form>

<div class="container">
	<h3>Lista de Libros</h3>
	<a href='ServletControladorFrontal?accion=formularioInsertar' class='btn btn-info btn-sm'><span class='glyphicon glyphicon-plus'></span>    Nuevo</a>
	<a href="ServletControladorFrontal?accion=envioLibro" class='btn btn-info btn-sm'><span class='glyphicon glyphicon-book'></span> Todos los capitulos</a>
		
	<table>

		<tr>
			<th><a href="ServletControladorFrontal?accion=ordenar&orden=titulo">Titulo</a></th>
			<th><a href="ServletControladorFrontal?accion=ordenar&orden=autor">Autor</a></th>
			<th><a href="ServletControladorFrontal?accion=ordenar&orden=paginas">Paginas</a></th>
		</tr>

<%-- 		<%for (Libro l : listaLibros) {%> --%>

<!-- 		<tr> -->
<%-- 			<td><%=l.getTitulo()%></td> --%>
<%-- 			<td><%=l.getAutor()%></td> --%>
<%-- 			<td><%=l.getPaginas()%></td> --%>
			
<%-- 			<th><a href="ServletControladorLibros?accion=editar&titulo=<%=l.getTitulo()%>" class='btn btn-warning btn-sm'><span class='glyphicon glyphicon-trash'></span>     Borrar</a></th> --%>
<%-- 			<th><a href="ServletControladorLibros?accion=editar&titulo=<%=l.getTitulo()%>" class='btn btn-primary btn-sm'><span class='glyphicon glyphicon-pencil'></span>     Editar</a></th> --%>
<%-- 			<th><a href="ServletControladorCapitulo?accion=envioLibro&titulo=<%=l.getTitulo()%>" class='btn btn-info btn-sm'><span class='glyphicon glyphicon-book'></span>     Ver capitulos</a></th> --%>
		
<!-- 		</tr> -->

<%-- 		<%}%> --%>
		
		
		
		
	<c:forEach items ="${listaLibros}" var="l">
     
         	<tr>
			<td>${l.titulo}</td>
			<td>${l.autor}</td>
			<td>${l.paginas}</td>
		
			<td><a href="ServletControladorFrontal?accion=borrar&titulo=${l.titulo}" class='btn btn-warning btn-sm'><span class='glyphicon glyphicon-trash'></span>     Borrar</a></td>
			<td><a href="ServletControladorFrontal?accion=editarFormulario&titulo=${l.titulo}" class='btn btn-primary btn-sm'><span class='glyphicon glyphicon-pencil'></span>     Editar</a></td>
			<td><a href="ServletControladorFrontal?accion=listaCapituloPorLibro&titulo=${l.titulo}" class='btn btn-info btn-sm'><span class='glyphicon glyphicon-book'></span>     Ver capitulos</a></td>
		
		</tr>
      </c:forEach>
      
      
      
	</table>
	
</div>	
<!-- <a href="ServletControladorLibros?accion=formularioInsertar"/>insertar</a> -->
</body>
</html>