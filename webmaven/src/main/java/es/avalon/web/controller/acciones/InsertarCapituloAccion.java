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

public class InsertarCapituloAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



		//LibroRepositorioJPA repoLibro = new LibroRepositorioJPA();

		//CapituloRepositorioJPA repoCapitulo = new CapituloRepositorioJPA();
		ServicioLibros sl = new ServicioLibros();

		Libro libro = sl.buscarUnoLibro(request.getParameter("libro_titulo"));
		Capitulo capitu = new Capitulo(request.getParameter("titulo"), Integer.parseInt(request.getParameter("paginas")),libro);
		//capitu.setLibro(libro);
		sl.insertarCapitulo(capitu);

		//request.setAttribute("listaCapitulo", repoCapitulo.buscarTodosParaUnLibro(libro));

		//	despachar(request, response, "listadoCapitulos.jsp");	

		response.sendRedirect("ServletControladorFrontal?accion=listaCapituloPorLibro&titulo="+request.getParameter("libro_titulo"));

	}

}
