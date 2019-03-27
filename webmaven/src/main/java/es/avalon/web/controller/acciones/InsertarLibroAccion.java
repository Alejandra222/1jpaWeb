package es.avalon.web.controller.acciones;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.LibroRepositorioJPA;

public class InsertarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		//persistencia3(request, response);
		
		Libro miLibro = new Libro(request.getParameter("titulo"), request.getParameter("autor"),
				Integer.parseInt(request.getParameter("paginas")));

		LibroRepositorioJPA repositorio = new LibroRepositorioJPA();
		repositorio.insertar(miLibro);
	 
		List<Libro> lista = repositorio.buscarTodos();
		request.setAttribute("listaLibros", lista);

		despachar(request, response, "listado.jsp");

	}

//	private void persistencia3(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		Libro miLibro = new Libro(request.getParameter("titulo"), request.getParameter("autor"),
//				Integer.parseInt(request.getParameter("paginas")));
//		miLibro.insertar();
//
//		List<Libro> lista = Libro.buscarTodos();
//		request.setAttribute("listaLibros", lista);
//
//		despachar(request, response, "listado.jsp");
//	}

}