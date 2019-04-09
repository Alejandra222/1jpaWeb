package es.avalon.web.controller.acciones;

import java.io.IOException;

import java.util.List;

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
public class DeleteCapituloAccion extends Accion {

	@Autowired
	ServicioLibros miservicio;
	
	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(request.getParameter("libro_titulo")+" ************OBTENGO " + request.getParameter("titulo"));
		
		//ServicioLibros sl = new ServicioLibrosImpl();
		//sl.deleteCapitulo(new Capitulo(request.getParameter("titulo")));
		miservicio.deleteCapitulo(new Capitulo(request.getParameter("titulo")));
		
		response.sendRedirect("ServletControladorFrontal?accion=envioLibro&libro_titulo="+request.getParameter("libro_titulo"));
		
		//despachar(request, response, "listadoCapitulos.jsp");
		
	

	}


}
