<%@page import="es.avalon.jpa.negocio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<%-- <%Libro libroEditar =(Libro)request.getAttribute("editoLibro");%> --%>

<div class="container">

		<h3 align="center" class="tituloNuevoLibro"> Libro  
			<span class="glyphicon glyphicon-edit"></span>  
		</h3>
		<form action="ServletControladorFrontal">
			<div class='row'>
				<div class='col-xs-3'>
					<p>
						T�tulo libro: <input type="text" name="titulo"
							value="${editoLibro.titulo}" disabled/>
					</p>

				</div>
				<div class='col-xs-1'></div>
				<div class='col-xs-3'>

					<p>
						Autor: <input type="text" name="autor"
							value="${editoLibro.autor}" />
					</p>
				</div>
				<div class='col-xs-1'></div>
				<div class='col-xs-3'>
					<p>
						P�ginas: <input type="text" name="paginas"
							value="${editoLibro.paginas}" />
					</p>
					<br> <input type="submit" value="Salvar" class='btn btn-warning' />
					
<!-- 					Campos ocultos -->
					<input type="hidden" name="titulo"
							value="${editoLibro.titulo}"/>
					 <input
						type="hidden" name="accion" value="salvar" />
						
						<a href="ServletControladorFrontal?accion=" class='colorNuevo marginSalir'><span
							class='glyphicon glyphicon-log-in'></span> Salir</a>
				
				
				</div>
			</div>
		</form>
	</div>
	
	
</body>
</html>