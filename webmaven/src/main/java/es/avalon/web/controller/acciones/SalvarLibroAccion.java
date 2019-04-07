package es.avalon.web.controller.acciones;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.LibroRepositorioJPA;
import es.avalon.servicios.ServicioLibros;

public class SalvarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Libro miLibro = new Libro(request.getParameter("titulo"), request.getParameter("autor"),
				Integer.parseInt(request.getParameter("paginas")));

		//LibroRepositorioJPA repo = new LibroRepositorioJPA();
		ServicioLibros sl = new ServicioLibros();
		sl.salvarLibro(miLibro);

		List<Libro> lista = sl.buscarTodosLosLibros();
		request.setAttribute("listaLibros", lista);

		despachar(request, response, "listado.jsp");

	

	}

}
