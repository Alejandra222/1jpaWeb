package es.avalon.web.controller.acciones;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.repositorios.jpa.CapituloRepositorioJPA;
import es.avalon.servicios.ServicioLibros;
import es.avalon.servicios.impl.ServicioLibrosImpl;


@Component
public class FormularioEditarCapitulo extends Accion {

	@Autowired
	ServicioLibros miservicio;
	
	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("************OBTENGO " + request.getParameter("titulo"));
		
		//ServicioLibros sl = new ServicioLibrosImpl();
		//Capitulo capiEdit = sl.buscarUnCapitulo(request.getParameter("titulo"));
		Capitulo capiEdit =miservicio.buscarUnCapitulo(request.getParameter("titulo"));
		
		System.out.println("PEPE*******  "+capiEdit.getTitulo());
		request.setAttribute("editoLibro", capiEdit);
		request.setAttribute("libro_titulo", request.getParameter("libro_titulo"));
		despachar(request, response, "formularioEditarCapitulos.jsp");

	}

}
