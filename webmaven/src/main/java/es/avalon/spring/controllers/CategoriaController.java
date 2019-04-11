package es.avalon.spring.controllers;

import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.avalon.jpa.negocio.Libro;
import es.avalon.servicios.ServicioLibros;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	ServicioLibros miservicio;
	
	@RequestMapping("/lista")
	public String listar(Model modelo) {
		
		//pasa datos a la vista
		modelo.addAttribute("listaLibros", miservicio.buscarTodosLosCategorias());
		return "categorias/lista";
	}
	
	
	
	
	@RequestMapping("/formularioInsertar")
	public String formularioInsertar(Model modelo) {
		modelo.addAttribute("libro", new Libro());
		return "libros/formularioInsertar";
	}
	
//	@RequestMapping("/insertar")
//	public String insertar(@ModelAttribute Libro libro, Model modelo) {
//				
//		miservicio.insertarLibro(libro);
//		modelo.addAttribute("listaLibros", miservicio.buscarTodosLosLibros());
//		
//		return "libros/lista";
//	}
	
	
/*	
 * PARA UTILIZAR @Valid NECESITASMOS ESTA DEPENDENCIA EN EL Pom.xml de jpa001Maven
	<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>2.0.1.Final</version>
</dependency>

<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.0.16.Final</version>
</dependency>


EN LA CLASE LIBRO TENEMOS @NotEmpty   @Pattern(regexp="^[A-Za-z] {5,10}$")
	@Id
	@NotEmpty
	@Pattern(regexp="^[A-Za-z] {5,10}$")
	private String titulo;
	private String autor;
	private int paginas;
*/	
	@RequestMapping(value="/insertar", method=RequestMethod.POST)
	public String insertar(@Valid @ModelAttribute Libro libro, BindingResult resultado, Model modelo) {
	//IMPORTANTE EL ORDEN: @Valid @ModelAttribute Libro libro, BindingResult resultado	
		System.out.println("TITULO: "+libro.getTitulo());
		System.out.println("ERROR: "+resultado.hasErrors());
		
		
		if(resultado.hasErrors()) {
			return"libros/formularioInsertar";
		}else {
		
		miservicio.insertarLibro(libro);
		modelo.addAttribute("listaLibros", miservicio.buscarTodosLosLibros());
		
		return "libros/lista";
		
		}
	}
	
	
	
	//@ModelAttribute recoje el String titulo del html y lo asigna a la propiedad titulo del objeto Libro
	@RequestMapping("/borrar")
	public String borrar(@ModelAttribute Libro libro, Model modelo) {
		
		miservicio.deleteLibro(libro);
		modelo.addAttribute("listaLibros", miservicio.buscarTodosLosLibros());
		
		return "libros/lista";
	}
	
	@RequestMapping("/editarFormulario")
	public String formularioEditar(Model modelo, String titulo) {
	
		Libro libro = miservicio.buscarUnoLibro(titulo);
		modelo.addAttribute("editoLibro", libro);
		
		return "libros/formularioEditar";
	}
	
	@RequestMapping("/salvar")
	public String salvar(Model modelo, Libro libro) {
	
		miservicio.salvarLibro(libro);
		modelo.addAttribute("listaLibros", miservicio.buscarTodosLosLibros());
		
		return "libros/lista";
	}
	

	
	/*@RequestMapping("/verCapitulos")
	public String irTodosLosCapitulos(Model modelo, String libro_titulo) {
	
		modelo.addAttribute("libro_titulo", libro_titulo);
		modelo.addAttribute("listaCapitulo", miservicio.buscarTodosCapitulo());
		
		return "libros/listadoCapitulos";
	}*/
	
	
}
