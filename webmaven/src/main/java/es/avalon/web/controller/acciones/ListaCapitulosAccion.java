package es.avalon.web.controller.acciones;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;
import es.avalon.servicios.ServicioLibros;

public class ListaCapitulosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		 System.out.println("Listar Todos los capitulos");
		List<Capitulo> lista =  new ServicioLibros().buscarTodosCapitulo();
		request.setAttribute("listaCapitulo", lista);
		despachar(request, response, "listadoCapitulos.jsp");
		
		

	}

}
