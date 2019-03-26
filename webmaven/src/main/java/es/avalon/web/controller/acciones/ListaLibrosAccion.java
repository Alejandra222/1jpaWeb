package es.avalon.web.controller.acciones;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.LibroRepositorioJPA;



public class ListaLibrosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		 LibroRepositorioJPA lr= new LibroRepositorioJPA();
		 List<Libro> lista =lr.buscarTodos();
		 
		request.setAttribute("listaLibros", lista);

		despachar(request, response, "listado.jsp");

		//persisitencia3(request, response);
	}

//	private void persisitencia3(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		List<Libro> lista = Libro.buscarTodos();
//		request.setAttribute("listaLibros", lista);
//
//		despachar(request, response, "listado.jsp");
//	}

}
