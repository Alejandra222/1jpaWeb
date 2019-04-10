package es.avalon.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import es.avalon.jpa.negocio.Libro;
import es.avalon.servicios.ServicioLibros;

@Controller
@RequestMapping("/libros")
public class LibroController {

	@Autowired
	ServicioLibros miservicio;
	
	@RequestMapping("/lista")
	public String listar(Model modelo) {
		
		//pasa datos a la vista
		modelo.addAttribute("listaLibros", miservicio.buscarTodosLosLibros());
		return "libros/lista";
	}
	
	@RequestMapping("/formularioInsertar")
	public String formularioInsertar() {
		
		return "libros/formularioInsertar";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute Libro libro, Model modelo) {
		
		miservicio.insertarLibro(libro);
		modelo.addAttribute("listaLibros", miservicio.buscarTodosLosLibros());
		
		return "libros/lista";
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
	
	@RequestMapping("/search")
	public String search(Model modelo, String titulo) {
	
		modelo.addAttribute("listaLibros", miservicio.searchLibro(titulo));
		
		return "libros/lista";
	}
	
	/*@RequestMapping("/verCapitulos")
	public String irTodosLosCapitulos(Model modelo, String libro_titulo) {
	
		modelo.addAttribute("libro_titulo", libro_titulo);
		modelo.addAttribute("listaCapitulo", miservicio.buscarTodosCapitulo());
		
		return "libros/listadoCapitulos";
	}*/
	
	@RequestMapping("/ordenarCampos")
	public String ordenarCampos(Model modelo, String campo) {
	
		modelo.addAttribute("listaLibros", miservicio.buscarTodosOrdenadosPorCampoLibro(campo));
		
		return "libros/lista";
	}
}
