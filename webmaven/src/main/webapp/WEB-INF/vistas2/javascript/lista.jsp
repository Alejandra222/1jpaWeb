
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="../resources/jquery-3.4.0.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>


<script type="text/javascript">

$(document).ready(function(){
	
	
	//LISTA TODOS LOS LIBROS
	$("#ajax").click(function(){
		var $listaLibros =$("#listaLibros").empty();
		//done: cuando la promesa finalice correctamente
		listar().done(function(datos){
			console.log(datos);	
			datos.forEach((libro)=> {
				$(`<option>\${libro.titulo}</option>`).appendTo("#listaLibros");

			});
		});
	});
		

	
	
	
	//LISTA LOS CAPITULOS DE UN LIBRO
		$("#listaLibros").change(function(){
			var libro =$(this).val();
		
		$.get(`../webapi/libros/\${libro}/capitulos`, function(datos){
			
			console.log(datos);
			
			var $miselect = $("<select id='listaCap'/>");
			$('#listaCap').remove();
			
			datos.forEach((capitulo)=>  {
	
				$(`<option>\${capitulo.titulo}</option>`).appendTo($miselect);
			})
			
						$("body").append($miselect);
		})
		
		});
		
		
	//INSERTA UN LIBRO	
		$("#botonInsertar").click(function() {
		
			//console.log($("#titulo").val());
			//console.log($("#autor").val());
			//console.log($("#paginas").val());
			
			var libro={};
			libro.titulo =$("#titulo").val();
			libro.autor =$("#autor").val();
			libro.paginas =$("#paginas").val();
			console.log(JSON.stringify(libro));
			
			var libroJson =JSON.stringify(libro);
			//insertar(libroJson)--> esto devuelve una promesa
			//done(function(datos)--> una vez finalizado 
			//then(listar) -->	si el done va bien ejecuta el metodo listar del then y sino va bien ejecutaria el fail	
			insertar(libroJson).then(listar).done(function(datos){

				var $listaLibros =$("#listaLibros").empty();
				datos.forEach((libro)=> {
					
					$(`<option>\${libro.titulo}</option>`).appendTo($listaLibros);
				})
			
			}).fail(function(error){
				console.log(error);
			});
			
// 			.success(function(datos){
// 				console.log("finaliza" + datos)
// 			});
			
			
// 			$.ajax({
// 				url:'../webapi/libros',
// 				type:'post',
// 				dataType:'json',
// 				contentType:'application/json',
// 				success: function (data){
// 					console.log("todo ok");
// 				},
				
				
// 				data:JSON.stringify(libro)
				
				
// 			});
		
	});
		
		
		//BORRA UN LIBRO
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
			
			
			
			
			//**************************
			
			function insertar(libroJson){
				
				return $.ajax({
					url:'../webapi/libros',
					type:'post',
					contentType:'application/json',
					success: function (data){
	 					console.log("todo ok");
	 				},
					data:libroJson
					
					
				});
				
			}
			
			
			
			
			function listar(){
				
				return 	$.get("../webapi/libros");
			}
			
	
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