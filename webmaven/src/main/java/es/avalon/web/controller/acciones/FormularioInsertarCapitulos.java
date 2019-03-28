package es.avalon.web.controller.acciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormularioInsertarCapitulos extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("libro_titulo", request.getParameter("libro_titulo"));
		despachar(request, response, "formularioInsertarCapitulos.jsp");

	}

}
