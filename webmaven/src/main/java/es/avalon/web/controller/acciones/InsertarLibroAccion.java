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
public class InsertarLibroAccion extends Accion {

	@Autowired
	ServicioLibros miservicio;
	
	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		Libro miLibro = new Libro(request.getParameter("titulo"), request.getParameter("autor"),
				Integer.parseInt(request.getParameter("paginas")));

		
		//ServicioLibros sl = new ServicioLibros();
		//sl.insertarLibro(miLibro);
		miservicio.insertarLibro(miLibro);

		List<Libro> lista = miservicio.buscarTodosLosLibros();


		request.setAttribute("listaLibros", lista);

		despachar(request, response, "listado.jsp");

	}

}
