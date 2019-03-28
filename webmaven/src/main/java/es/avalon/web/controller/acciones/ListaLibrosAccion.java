package es.avalon.web.controller.acciones;

import java.io.IOException;



import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.LibroRepositorioJPA;
import es.avalon.servicios.ServicioLibros;



public class ListaLibrosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		 
		List<Libro> lista =new ServicioLibros().buscarTodosLosLibros();
		 
		request.setAttribute("listaLibros", lista);

		despachar(request, response, "listado.jsp");


	}

//	private void persisitencia3(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		List<Libro> lista = Libro.buscarTodos();
//		request.setAttribute("listaLibros", lista);
//
//		despachar(request, response, "listado.jsp");
//	}

}
