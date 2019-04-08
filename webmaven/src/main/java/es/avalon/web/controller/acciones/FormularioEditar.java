package es.avalon.web.controller.acciones;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.jpa.LibroRepositorioJPA;
import es.avalon.servicios.ServicioLibros;


@Component
public class FormularioEditar extends Accion {

	
	@Autowired
	ServicioLibros miservicio;
	
	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("************OBTENGO " + request.getParameter("titulo"));
		String titulo =request.getParameter("titulo");
		
		//ServicioLibros sl = new ServicioLibros();
		Libro libro =miservicio.buscarUnoLibro(titulo);
		
		request.setAttribute("editoLibro", libro);
		
		despachar(request, response, "formularioEditar.jsp");
		
	}

}
