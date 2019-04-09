package es.avalon.web.controller.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.avalon.jpa.negocio.Libro;
import es.avalon.servicios.ServicioLibros;


@Component
public class SearchLibroAccion extends Accion {

	@Autowired
	ServicioLibros miservicio;
	
	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Search libros");
		//List<Libro> lista =new ServicioLibros().searchLibro(request.getParameter("titulo"));
		List<Libro> lista = (List<Libro>) miservicio.searchLibro(request.getParameter("titulo"));

		request.setAttribute("listaLibros", lista);

		despachar(request, response, "listado.jsp");
	}

}
