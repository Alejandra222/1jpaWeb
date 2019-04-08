package es.avalon.web.controller.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.servicios.impl.ServicioLibrosImpl;


@Component
public class searchCapituloAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			List<Capitulo> lista =  new ServicioLibrosImpl().searchCapitulo(
					request.getParameter("titulo"), request.getParameter("libro_titulo"));
			request.setAttribute("listaCapitulo", lista);
			despachar(request, response, "listadoCapitulos.jsp");
			
			

	}

}
