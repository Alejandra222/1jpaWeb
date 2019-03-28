package es.avalon.web.controller.acciones;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.LibroRepositorioJPA;
import es.avalon.servicios.ServicioLibros;

public class FormularioEditar extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//persistencia3(request, response);
		
		System.out.println("************OBTENGO " + request.getParameter("titulo"));
		String titulo =request.getParameter("titulo");
		
		//LibroRepositorioJPA repositorio = new LibroRepositorioJPA();
		ServicioLibros sl = new ServicioLibros();
		Libro libro =sl.buscarUnoLibro(titulo);
		
		request.setAttribute("editoLibro", libro);
		
		despachar(request, response, "formularioEditar.jsp");
		
	}

//	private void persistencia3(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("************OBTENGO " + request.getParameter("titulo"));
//		Libro lEditar=Libro.buscarUnLibroPorTitulo(request.getParameter("titulo"));
//		
//		request.setAttribute("editoLibro", lEditar);
//		
//		despachar(request, response, "formularioEditar.jsp");
//	}

}
