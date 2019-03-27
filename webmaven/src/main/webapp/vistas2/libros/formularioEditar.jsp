<%@page import="es.avalon.jpa.negocio.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Libro libroEditar =(Libro)request.getAttribute("editoLibro");%>
	
	<h3>Actualizar libro</h3>
<form action="ServletControladorFrontal">

<%-- <p>Titulo: <input type="text" name="titulo" value="<%=libroEditar.getTitulo()%>"/></p> --%>
<%-- <p>Autor: <input type="text" name="autor" value="<%=libroEditar.getAutor()%>"/></p> --%>
<%-- <p>Paginas: <input type="text" name="paginas" value="<%=libroEditar.getPaginas()%>"/></p><br> --%>


<p>Titulo: <input type="text" name="titulo" value="${editoLibro.titulo}"/></p>
<p>Autor: <input type="text" name="autor" value="${editoLibro.autor}"/></p>
<p>Paginas: <input type="text" name="paginas" value="${editoLibro.paginas}"/></p><br>


<input type="submit" value="enviar"/>

 <input type="hidden" name="accion" value="salvar"/>
</form>

</body>
</html>