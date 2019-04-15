<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<div class='row'>
  <div class='col-xs-9'></div>	
	 <div class='col-xs-3'>
 <a href="lista" class='colorNuevo'>
   <span class="glyphicon glyphicon-log-in"></span> 
   Salir</a> 
	</div>
	</div>
	
		<h3 align="center" class="tituloNuevoLibro">
			Nueva <span class='glyphicon glyphicon-folder-open'></span>
		</h3>
	
  
		
		 
<form:form method="POST"
  action="insertar" modelAttribute="categoria">
 <div class='row'>
 <div class='col-xs-4'>
  <form:label path="id">ID</form:label><br>
  <form:input path="id"/>
  <form:errors path="id"></form:errors>
</div>
<div class='col-xs-2'></div>
<div class='col-xs-4'>
 <form:label path="nombre">NOMBRE</form:label><br>
 <form:input path="nombre"/>
  </div> 
 </div> 
 
  <div class='row margintop'>
  <div class='col-xs-6'></div>
  <div class='col-xs-3'>
 <input type="submit" value="Guardar" class='btn btn-warning'/>
  </div>
 
	</div>
  </form:form>
     
	

<%-- 		<form action="insertar"> --%>

<!-- 			<div class='row'> -->
<!-- 				<div class='col-xs-3'> -->
<!-- 					<p> -->
<!-- 						Título libro: <input type="text" name="titulo" /> -->
<!-- 					</p> -->
<!-- 				</div> -->
<!-- 					<div class='col-xs-1'></div> -->
<!-- 				<div class='col-xs-3'> -->
<!-- 					<p> -->
<!-- 						Autor: <input type="text" name="autor" /> -->
<!-- 					</p> -->
<!-- 				</div> -->
<!-- 				<div class='col-xs-1'></div> -->
<!-- 				<div class='col-xs-3'> -->
<!-- 					<p> -->
<!-- 						Páginas: <input type="text" name="paginas" /> -->
<!-- 					</p> -->
<!-- 					<br>  -->
<!-- 						<input type="submit" value="Guardar" class='btn btn-warning'> -->
					
<!-- 					<a href="lista" class='colorNuevo marginSalir'><span -->
<!-- 							class='glyphicon glyphicon-log-in'></span> Salir</a> -->
				
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<input type="hidden" name="accion" value="insertar" /> -->

<%-- 		</form> --%>
	
   
	
	 
</div>

</body>
</html>