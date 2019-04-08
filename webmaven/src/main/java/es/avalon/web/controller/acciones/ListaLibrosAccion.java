package es.avalon.web.controller.acciones;

import java.io.IOException;



import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.jpa.LibroRepositorioJPA;
import es.avalon.servicios.ServicioLibros;


@Component
public class ListaLibrosAccion extends Accion {
	
	@Autowired
	ServicioLibros miservicio;

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		 System.out.println("Listar Todos los libros");
		//List<Libro> lista =new ServicioLibros().buscarTodosLosLibros();
		 List<Libro> lista = miservicio.buscarTodosLosLibros(); 
		request.setAttribute("listaLibros", lista);

		despachar(request, response, "listado.jsp");


	}

}
