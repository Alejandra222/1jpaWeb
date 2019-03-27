<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Añadir libro</h3>
<form action="ServletControladorFrontal">

<p>Titulo: <input type="text" name="titulo"/></p>
<p>Autor: <input type="text" name="autor"/></p>
<p>Paginas: <input type="text" name="paginas"/></p><br>

<input type="submit" value="enviar"/>

 <input type="hidden" name="accion" value="insertar"/>
</form>

</body>
</html>