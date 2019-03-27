package es.avalon.web.controller.acciones;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class Accion {

	private static final String RUTA = "vistas2/libros/";
	
	public abstract void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void despachar(HttpServletRequest request, HttpServletResponse response, String ficheroJSP)
			throws ServletException, IOException {
		
		RequestDispatcher despachador = request.getRequestDispatcher(RUTA + ficheroJSP);
		despachador.forward(request, response);
	}

}
