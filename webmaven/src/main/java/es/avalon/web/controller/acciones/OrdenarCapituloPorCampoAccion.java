package es.avalon.web.controller.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.servicios.ServicioLibros;

public class OrdenarCapituloPorCampoAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		List<Capitulo> lista =  new ServicioLibros().OrdenarCapitulosPorCampo(
				request.getParameter("filtro"), request.getParameter("libro_titulo"));
		request.setAttribute("listaCapitulo", lista);
		despachar(request, response, "listadoCapitulos.jsp");
		
		
	}

}
