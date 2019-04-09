package es.avalon.web.controller.acciones;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.jpa.CapituloRepositorioJPA;
import es.avalon.repositorios.jpa.LibroRepositorioJPA;
import es.avalon.servicios.ServicioLibros;

@Component
public class MostrarCapitulosDeLibro extends Accion {


	@Autowired
	ServicioLibros miservicio;
	
	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//ServicioLibros sl = new ServicioLibros();
		//List<Capitulo> lista = sl.buscarTodosParaUnLibroCapitulo(new Libro(request.getParameter("libro_titulo")));
		List<Capitulo> lista = (List<Capitulo>) miservicio.buscarTodosParaUnLibroCapitulo(new Libro(request.getParameter("libro_titulo")));

		request.setAttribute("listaCapitulo", lista);

		despachar(request, response, "listadoCapitulos.jsp");		


	}

}
