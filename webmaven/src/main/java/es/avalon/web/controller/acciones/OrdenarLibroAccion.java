package es.avalon.web.controller.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.LibroRepositorioJPA;
import es.avalon.servicios.ServicioLibros;

public class OrdenarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		// LibroRepositorioJPA lr= new LibroRepositorioJPA();
		ServicioLibros sl = new ServicioLibros();
		 List<Libro> lista =sl.buscarTodosOrdenadosPorCampoLibro(request.getParameter("accion"));
		 
		request.setAttribute("listaLibros", lista);

		despachar(request, response, "listado.jsp");
	}

}
