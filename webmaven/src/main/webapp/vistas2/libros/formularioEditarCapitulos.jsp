
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<h3>Actualizar libro</h3>
<form action="ServletControladorFrontal">



<p>Titulo: <input type="text" name="titulo" value="${editoLibro.titulo}"/></p>
<p>Paginas: <input type="text" name="paginas" value="${editoLibro.paginas}"/></p><br>
<p>Libro: <input type="text" name="libro_titulo" value="${param.libro_titulo}"/></p>


<input type="submit" value="enviar"/>

 <input type="hidden" name="accion" value="salvarCapitulo"/>
</form>

</body>
</html>