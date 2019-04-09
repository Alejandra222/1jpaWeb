package es.avalon.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String listar() {
		
		return "libros/formularioInsertar";
	}
}
