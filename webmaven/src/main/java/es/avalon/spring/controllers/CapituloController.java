package es.avalon.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;
import es.avalon.servicios.ServicioLibros;

@Controller
@RequestMapping("/capitulos")
public class CapituloController {

	@Autowired
	ServicioLibros miservicio;
	
	/*@RequestMapping("/listado")
	public String listar(Model modelo) {
		
		//pasa datos a la vista
		modelo.addAttribute("listaCapitulo", miservicio.buscarTodosCapitulo());
		return "libros/listadoCapitulos";
	}*/
	
	@RequestMapping("/lista")
	public String listar(Model modelo, String libro_titulo) {
	
		modelo.addAttribute("libro_titulo", libro_titulo);
		modelo.addAttribute("listaCapitulo", miservicio.buscarTodosParaUnLibroCapitulo(new Libro(libro_titulo)));
		return "capitulos/lista";
	}
	
	@RequestMapping("/listaTodos")
	public String listarTodos(Model modelo, String libro_titulo) {
	
		modelo.addAttribute("libro_titulo", libro_titulo);
		modelo.addAttribute("listaCapitulo", miservicio.buscarTodosCapitulo());
		return "capitulos/lista";
	}
	
	@RequestMapping("/formularioInsertar")
	public String formularioInsertar(Model modelo, String libro_titulo) {
		modelo.addAttribute("libro_titulo", libro_titulo);
		
		return "capitulos/formularioInsertar";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@ModelAttribute Capitulo capitulo, String libro_titulo, Model modelo) {
	//public String insertar(String titulo, int paginas, String libro_titulo, Model modelo) {	
		Libro l = new Libro(libro_titulo);
		capitulo.setLibro(l);
		//Capitulo capitulo = new Capitulo(titulo,paginas, l);
		miservicio.insertarCapitulo(capitulo);
		modelo.addAttribute("listaCapitulo",  miservicio.buscarTodosParaUnLibroCapitulo(new Libro(libro_titulo)));
		
		return "capitulos/lista";
	}
	
	
	//@ModelAttribute recoje el String titulo del html y lo asigna a la propiedad titulo del objeto Libro
	@RequestMapping("/borrar")
	public String borrar(@ModelAttribute Capitulo capitulo, String libro_titulo, Model modelo) {
		Libro l = new Libro(libro_titulo);
		capitulo.setLibro(l);
		System.out.println(capitulo.getTitulo());
		miservicio.deleteCapitulo(capitulo);
		modelo.addAttribute("listaCapitulo", miservicio.buscarTodosParaUnLibroCapitulo(new Libro(libro_titulo)));
		
		return "capitulos/lista";
	}
	
	
	@RequestMapping("/editarFormulario")
	public String formularioEditar(Model modelo, String titulo, String libro_titulo) {
	
		Capitulo capitulo = miservicio.buscarUnCapitulo(titulo);
		modelo.addAttribute("libro_titulo", libro_titulo);
		modelo.addAttribute("editoLibro", capitulo);
		
		return "capitulos/formularioEditar";
	}
	
	
	
	@RequestMapping("/salvar")
	public String salvar(Model modelo, @ModelAttribute Capitulo capitulo, String libro_titulo) {
		Libro libro = miservicio.buscarUnoLibro(libro_titulo);
		capitulo.setLibro(libro);
		
		miservicio.salvarCapitulo(capitulo);
		//modelo.addAttribute("libro_titulo", libro_titulo);
		modelo.addAttribute("listaCapitulo", miservicio.buscarTodosParaUnLibroCapitulo(new Libro(libro_titulo)));
		
		return "capitulos/lista";
	}
	
	
	@RequestMapping("/search")
	public String search(Model modelo, String libro_titulo, String titulo) {
	
		modelo.addAttribute("listaCapitulo", miservicio.searchCapitulo(titulo, libro_titulo));
		
		return "capitulos/lista";
	}
	
	@RequestMapping("/ordenarCampo")
	public String ordenarCampos(Model modelo, String campo, String libro_titulo) {
	
		modelo.addAttribute("listaCapitulo", miservicio.OrdenarCapitulosPorCampo(campo, libro_titulo));
		
		return "capitulos/lista";
	}
}
