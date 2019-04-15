<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="jquery-3.3.1.js"></script>

<script type="text/javascript">


	  $(document).ready(function (){
		 //  $("#paginas").val()= null;
		 // alert($("#paginas").val());
		  
	      $('.solo-numero').keyup(function (){
	        this.value = (this.value + '').replace(/[^0-9]/g, '');
	      });
	    });
		

</script>


<link rel='stylesheet' type='text/css' href='../resources/css/css1.css'>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js'></script>


</head>
 
<body>
����<div class="container">

		<h3 align="center" class="tituloNuevoLibro">
			Nuevo <span class="glyphicon glyphicon-book"></span>
		</h3>
		
		�
<form:form method="POST"
  action="insertar" modelAttribute="libro">
  <table>
  
  <tr>
  <td><form:label path="titulo">Titulo</form:label></td>
  <td><form:input path="titulo"/><br>
  <form:errors path="titulo"></form:errors>
  </td>
  </tr>
  
    <tr>
  <td><form:label path="autor">Autor</form:label></td>
  <td><form:input path="autor"/><br>
  <form:errors path="autor"></form:errors>
  </td>
  </tr>
  
    <tr>
  <td><form:label path="paginas">Paginas</form:label></td>
  <td><form:input class="solo-numero" path="paginas" value="" id="paginas"/><br>
    <form:errors path="paginas"></form:errors>
    </td>
  </tr>
  
  <tr>
  <td><input type="submit" value="Guardar" class='btn btn-warning'/></td>
  
  
  <td><a href="lista" class='colorNuevo marginSalir'>
   <span class="glyphicon glyphicon-log-in"></span> 
  
  Salir</a> </td>
	
  </tr>
  </table>
  </form:form>
  ���
	

<%-- 		<form action="insertar"> --%>

<!-- 			<div class='row'> -->
<!-- 				<div class='col-xs-3'> -->
<!-- 					<p> -->
<!-- 						T�tulo libro: <input type="text" name="titulo" /> -->
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
<!-- 						P�ginas: <input type="text" name="paginas" /> -->
<!-- 					</p> -->
<!-- 					<br>  -->
<!-- 						<input type="submit" value="Guardar" class='btn btn-warning'> -->
					
<!-- 					<a href="lista" class='colorNuevo marginSalir'><span -->
<!-- 							class='glyphicon glyphicon-log-in'></span> Salir</a> -->
				
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<input type="hidden" name="accion" value="insertar" /> -->

<%-- 		</form> --%>
	
���
	
	�
</div>

</body>
</html>