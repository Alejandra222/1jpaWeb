package es.avalon.web.controller.acciones;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.jpa.CapituloRepositorioJPA;
import es.avalon.repositorios.jpa.LibroRepositorioJPA;
import es.avalon.servicios.ServicioLibros;
import es.avalon.servicios.impl.ServicioLibrosImpl;

@Component
public class SalvarCapituloAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//LibroRepositorioJPA repoLibro = new LibroRepositorioJPA();
		//CapituloRepositorioJPA repoCapitulo = new CapituloRepositorioJPA();
		ServicioLibros sl = new ServicioLibrosImpl();

		Libro libro = sl.buscarUnoLibro(request.getParameter("libro_titulo"));
		Capitulo capitu = new Capitulo(request.getParameter("titulo"), Integer.parseInt(request.getParameter("paginas")),libro);
		
		sl.salvarCapitulo(capitu);
		//request.setAttribute("listaCapitulo", repoCapitulo.buscarTodosParaUnLibro(libro));

		//despachar(request, response, "listadoCapitulos.jsp");	
		
		response.sendRedirect("ServletControladorFrontal?accion=envioLibro&libro_titulo="+request.getParameter("libro_titulo"));
		
	}

}
