package es.avalon.web.controller.acciones;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.CapituloRepositorioJPA;
import es.avalon.repositorios.LibroRepositorioJPA;
import es.avalon.servicios.ServicioLibros;


public class MostrarCapitulosDeLibro extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		
		//		 CapituloRepositorioJPA lr= new CapituloRepositorioJPA();
		//		 List<Capitulo> lista =lr.buscarTodosCapitulosConSusLibros();
		//		 
		//			request.setAttribute("listaCapitulo", lista);
		//
		//			despachar(request, response, "listadoCapitulos.jsp");


		//CapituloRepositorioJPA rp= new CapituloRepositorioJPA();
		ServicioLibros sl = new ServicioLibros();
		List<Capitulo> lista = sl.buscarTodosParaUnLibroCapitulo(new Libro(request.getParameter("titulo")));

		request.setAttribute("listaCapitulo", lista);

		despachar(request, response, "listadoCapitulos.jsp");		


	}

}
