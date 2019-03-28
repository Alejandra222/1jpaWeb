package es.avalon.web.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.avalon.web.controller.acciones.FormularioInsertar;
import es.avalon.web.controller.acciones.FormularioInsertarCapitulos;
import es.avalon.web.controller.acciones.InsertarCapituloAccion;
import es.avalon.web.controller.acciones.InsertarLibroAccion;
import es.avalon.web.controller.acciones.Accion;
import es.avalon.web.controller.acciones.DeleteCapituloAccion;
import es.avalon.web.controller.acciones.DeleteLibroAccion;
import es.avalon.web.controller.acciones.FormularioEditar;
import es.avalon.web.controller.acciones.FormularioEditarCapitulo;
import es.avalon.web.controller.acciones.ListaLibrosAccion;
import es.avalon.web.controller.acciones.MostrarCapitulosDeLibro;
import es.avalon.web.controller.acciones.OrdenarLibroAccion;
import es.avalon.web.controller.acciones.SalvarCapituloAccion;
import es.avalon.web.controller.acciones.SalvarLibroAccion;



/**
 * Servlet implementation class ServletControladorFrontal
 */
public class ServletControladorFrontal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String tipoAccion = request.getParameter("accion");
		Accion accion = null;
		
		if (tipoAccion == null || tipoAccion.equals("")) {
				
			accion = new ListaLibrosAccion();
		
	}else {

			if (tipoAccion.equals("formularioInsertar")) {

				System.out.println("******************* LLEGA 1");
				accion = new FormularioInsertar();
				
		
			} else if (tipoAccion.equals("insertar")) {
	
				accion = new InsertarLibroAccion();
				
				
			} else if (tipoAccion.equals("borrar")) {

				
				accion = new DeleteLibroAccion();
			
				
			}else if (tipoAccion.equals("editarFormulario")) {
				System.out.println("*************** Entraaaaaaa   ");
				accion = new FormularioEditar();
			

			
			}else if (tipoAccion.equals("salvar")) {

			  accion = new SalvarLibroAccion();
			
				
			}else if (tipoAccion.equals("ordenar")) {

				  accion = new OrdenarLibroAccion();
				  
					
				}else if (tipoAccion.equals("envioLibro")) {

					accion = new MostrarCapitulosDeLibro();

					}else if (tipoAccion.equals("formularioInsertarCapitulo")) {
						
						accion = new FormularioInsertarCapitulos();
						
					}else if (tipoAccion.equals("insertarCapitulo")) {

						accion = new InsertarCapituloAccion();
					
					}else if (tipoAccion.equals("listaCapituloPorLibro")) {

						accion = new MostrarCapitulosDeLibro();
					
					}else if (tipoAccion.equals("borrarCapitulo")) {

						accion = new DeleteCapituloAccion();
					
					}else if (tipoAccion.equals("editarCapitulo")) {

						accion = new FormularioEditarCapitulo();
					
					}else if (tipoAccion.equals("salvarCapitulo")) {

						System.out.println("Hola *************+++");
						accion = new SalvarCapituloAccion();
					
					}


	}
		accion.ejecutar(request, response);
}}
