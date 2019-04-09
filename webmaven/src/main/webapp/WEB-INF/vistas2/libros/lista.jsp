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




<%-- 	<% List<Libro> listaLibros = (List<Libro>) request.getAttribute("listaLibros"); %> --%>

<div class="container">
<div class='row'>

<h3 align="center" class="titulo">   Libros   <span class="glyphicon glyphicon-search"></span></h3>

<div class='row'>
<div class='col-xs-4'></div>
<div class='col-xs-8'>
	
	<form action="">
	
		<p>
			<input class='glyphicon glyphicon-trash' type="text" name="titulo" placeholder=" título..." />
			<input type="submit" value="Buscar" class='btn btn-warning'>

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
<h3>Lista de <span class="glyphicon glyphicon-book"></span></h3>
</div>

<div class='col-xs-2 margintop'>	
	<a href="formularioInsertar" class='colorNuevo'><span class='glyphicon glyphicon-plus'></span>    Nuevo</a>
</div>

<div class='col-xs-3 margintop'>	
	<a href="ServletControladorFrontal?accion=listaCapitulos&libro_titulo=" class='colorNuevo'><span class='glyphicon glyphicon-list-alt'></span>   Capítulos</a>
</div>
</div>
	

	
	<table>

		<tr>
			<th><a href="ServletControladorFrontal?accion=titulo">TÍTULO</a></th>
			<th><a href="ServletControladorFrontal?accion=autor">AUTOR</a></th>
			<th><a href="ServletControladorFrontal?accion=paginas">PÁGINAS</a></th>
		</tr>

		
		
		<c:forEach items ="${listaLibros}" var="l">
     
         	<tr>
			<td>${l.titulo}</td>
			<td>${l.autor}</td>
			<td>${l.paginas}</td>
		
			<td><a href="ServletControladorFrontal?accion=borrar&titulo=${l.titulo}" class='btn btn-light btn-sm colorBorrar'><span class='glyphicon glyphicon-trash'></span>     Borrar</a></td>
			<td><a href="ServletControladorFrontal?accion=editarFormulario&titulo=${l.titulo}" class='btn btn-light btn-sm colorEditar'><span class='glyphicon glyphicon-pencil'></span>     Editar</a></td>
			<td><a href="ServletControladorFrontal?accion=envioLibro&libro_titulo=${l.titulo}" class='btn btn-light btn-sm colorIrCapitulo'><span class='glyphicon glyphicon-eye-open'></span>     Ver capitulos</a></td>
		
		</tr>
		
		
      </c:forEach>
      
	</table>
	
	</div>
</body>
</html>