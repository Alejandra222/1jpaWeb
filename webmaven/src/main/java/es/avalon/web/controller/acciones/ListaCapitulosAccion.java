package es.avalon.web.controller.acciones;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;
import es.avalon.servicios.ServicioLibros;

@Component
public class ListaCapitulosAccion extends Accion {

	@Autowired
	ServicioLibros miservicio;
	
	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		 System.out.println("Listar Todos los capitulos");
		//List<Capitulo> lista =  new ServicioLibros().buscarTodosCapitulo();
		List<Capitulo> lista =  (List<Capitulo>) miservicio.buscarTodosCapitulo();
		request.setAttribute("listaCapitulo", lista);
		despachar(request, response, "listadoCapitulos.jsp");
		
		

	}

}
