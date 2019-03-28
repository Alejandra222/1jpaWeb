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

public class InsertarCapituloAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Capitulo miLibro = new Capitulo(request.getParameter("titulo"), Integer.parseInt(request.getParameter("paginas")),request.getParameter("libro_titulo"));
//		
//		Capitulo capitulo = new Capitulo(request.getParameter("titulo"), Integer.parseInt(request.getParameter("paginas")));
//		
//		
//		CapituloRepositorioJPA repositorio = new CapituloRepositorioJPA();
//		repositorio.insertar(capitulo);
//		
//		List<Capitulo> lista = repositorio.buscarTodos();
//			
//			request.setAttribute("listaCapitulo", lista);
//
//			despachar(request, response, "listadoCapitulos.jsp");
//		
//			
//			
			
			LibroRepositorioJPA repoLibro = new LibroRepositorioJPA();
			
			CapituloRepositorioJPA repoCapitulo = new CapituloRepositorioJPA();
			
			Libro libro = repoLibro.buscarUno(request.getParameter("libro_titulo"));
			Capitulo capitu = new Capitulo(request.getParameter("titulo"), Integer.parseInt(request.getParameter("paginas")),libro);
			//capitu.setLibro(libro);
			repoCapitulo.insertar(capitu);
			
			//request.setAttribute("listaCapitulo", repoCapitulo.buscarTodosParaUnLibro(libro));

		//	despachar(request, response, "listadoCapitulos.jsp");	
			
			response.sendRedirect("ServletControladorFrontal?accion=listaCapituloPorLibro&titulo="+request.getParameter("libro_titulo"));

	}

}
