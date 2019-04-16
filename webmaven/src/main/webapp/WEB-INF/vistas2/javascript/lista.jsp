
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="../resources/jquery-3.4.0.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>


<script type="text/javascript">

$(document).ready(function(){
	
	$("#ajax").click(function(){
		
		$.get("../webapi/libros", function(datos){
			
			console.log(datos);
			
			datos.forEach((libro)=>{
	
				$(`<option>\${libro.titulo}</option>`).appendTo("#listaLibros");
			})
		})
	});
	
	
	
	
		$("#listaLibros").change(function(){
			var libro =$(this).val();
		
		$.get(`../webapi/libros/\${libro}/capitulos`, function(datos){
			
			console.log(datos);
			
			var $miselect = $("<select id='listaCap'/>");
			$('#listaCap').remove();
			
			datos.forEach((capitulo)=> {
	
				$(`<option>\${capitulo.titulo}</option>`).appendTo($miselect);
			})
			
						$("body").append($miselect);
		})
		
		});
		
		
		
		$("#botonInsertar").click(function() {
		
			//console.log($("#titulo").val());
			//console.log($("#autor").val());
			//console.log($("#paginas").val());
			
			var libro={};
			libro.titulo =$("#titulo").val();
			libro.autor =$("#autor").val();
			libro.paginas =$("#paginas").val();
			console.log(JSON.stringify(libro));
			
			
			
			$.ajax({
				url:'../webapi/libros',
				type:'post',
				dataType:'json',
				contentType:'application/json',
				success: function (data){
					console.log("todo ok");
				},
				data:JSON.stringify(libro)
				
				
			});
		
	});
		
		
		
		
			$("#botonBorrar").click(function() {
				var libro =$("#listaLibros").val();
				console.log(libro);
				
				$.ajax({
					url:'../webapi/libros/'+libro,
					type:'delete',
					dataType:'json',
					contentType:'application/json',
					success: function (data){
						console.log("todo ok");
					},
					//data:JSON.stringify(libro)
				});
				
			});
			
	
});
</script>
</head>
<body>

<select id="listaLibros">

</select>
hola desde javascript
<input type="button" id="ajax" value ="ajax">

<form>
<p>
<label for="titulo">titulo:</label> <input type="text" name="titulo" id="titulo"/>
</p>

<p>
<label for="autor">autor:</label> <input type="text" name="autor" id="autor"/>
</p>

<p>
<label for="paginas">paginas:</label> <input type="text" name="paginas" id="paginas"/>
</p>

<input type="button" value="aceptar" id="botonInsertar"/>
<input type="button" value="borrar" id="botonBorrar"/>
</form>
</body>
</html>