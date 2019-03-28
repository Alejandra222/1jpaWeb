<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Añadir Capitulo</h3>
<form action="ServletControladorFrontal">

<p>Titulo: <input type="text" name="titulo"/></p><br>
<p>Paginas: <input type="text" name="paginas"/></p><br> 
<p>Libro: <input type="text" name="libro_titulo" value="${param.titulo_libro}"/></p> 

<input type="submit" value="enviar"/>

 <input type="hidden" name="accion" value="insertarCapitulo"/>
</form>

</body>
</html>