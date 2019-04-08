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
public class OrdenarLibroAccion extends Accion {

	
	@Autowired
	ServicioLibros miservicio;
	
	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		//ServicioLibros sl = new ServicioLibros();
		 List<Libro> lista =miservicio.buscarTodosOrdenadosPorCampoLibro(request.getParameter("accion"));
		 
		request.setAttribute("listaLibros", lista);

		despachar(request, response, "listado.jsp");
	}

}
