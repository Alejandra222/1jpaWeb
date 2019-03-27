package es.avalon.web.controller.acciones;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.LibroRepositorioJPA;

public class DeleteLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		System.out.println("************OBTENGO " + request.getParameter("titulo"));
		Libro lb = new Libro(request.getParameter("titulo"));
		LibroRepositorioJPA repositorio= new LibroRepositorioJPA();
		
		repositorio.delete(lb);
		

		List<Libro> lista = repositorio.buscarTodos();
		request.setAttribute("listaLibros", lista);


		despachar(request, response, "listado.jsp");
	}

	
	
//	private void persistencia3(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("************OBTENGO " + request.getParameter("titulo"));
//		Libro lb = new Libro(request.getParameter("titulo"));
//		lb.deleteLibro();
//		
//
//		List<Libro> lista = Libro.buscarTodos();
//		request.setAttribute("listaLibros", lista);
//
//
//		despachar(request, response, "listado.jsp");
//	}

}
