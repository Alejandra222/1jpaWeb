package es.avalon.web.controller.acciones;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.repositorios.CapituloRepositorioJPA;
import es.avalon.servicios.ServicioLibros;

public class FormularioEditarCapitulo extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("************OBTENGO " + request.getParameter("titulo"));
		
		//CapituloRepositorioJPA repoCapitulo = new CapituloRepositorioJPA();
		ServicioLibros sl = new ServicioLibros();
		Capitulo capiEdit = sl.buscarUnCapitulo(request.getParameter("titulo"));
		
		System.out.println("PEPE*******  "+capiEdit.getTitulo());
		request.setAttribute("editoLibro", capiEdit);
		request.setAttribute("libro_titulo", request.getParameter("libro_titulo"));
		despachar(request, response, "formularioEditarCapitulos.jsp");

	}

}
