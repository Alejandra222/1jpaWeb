
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

	<div class="container">

		<h3 align="center" class="tituloNuevoLibro">
			Capitulo <span class="glyphicon glyphicon-edit"></span>
		</h3>
		<form action="salvar">
			<div class='row'>
				<div class='col-xs-3'>
					<p>
						Título capítulo: <input type="text" name="titulo"
							value="${editoLibro.titulo}" disabled />
					</p>

				</div>
				<div class='col-xs-1'></div>
				<div class='col-xs-3'>

					<p>
						Páginas: <input type="text" name="paginas"
							value="${editoLibro.paginas}" />
					</p>
				</div>
				<div class='col-xs-1'></div>
				<div class='col-xs-4'>
					<p>
						Libro: <input type="text" name="libro_titulo"
							value="${libro_titulo}" disabled />
					</p>
					<br> <input type="submit" value="salvar"
						class='btn btn-warning' />

					<!-- 					Campos ocultos -->
					<input type="hidden" name="titulo"
						value="${editoLibro.titulo}" /> 
						
						<input type="hidden"
						name="libro_titulo"
						value="${libro_titulo}" /> 
					
						<a
						href="lista?libro_titulo=${libro_titulo}"
						class='colorNuevo marginSalir'><span
						class='glyphicon glyphicon-log-in'></span> Salir</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>