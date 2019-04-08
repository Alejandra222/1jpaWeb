package es.avalon.web.controller;

import java.io.IOException;





import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.avalon.web.controller.acciones.FormularioInsertar;
import es.avalon.web.controller.acciones.FormularioInsertarCapitulos;
import es.avalon.web.controller.acciones.InsertarCapituloAccion;
import es.avalon.web.controller.acciones.InsertarLibroAccion;
import es.avalon.web.controller.acciones.ListaCapitulosAccion;
import es.avalon.configuracion.ConfiguracionSpring;
import es.avalon.web.controller.acciones.Accion;
import es.avalon.web.controller.acciones.DeleteCapituloAccion;
import es.avalon.web.controller.acciones.DeleteLibroAccion;
import es.avalon.web.controller.acciones.FormularioEditar;
import es.avalon.web.controller.acciones.FormularioEditarCapitulo;
import es.avalon.web.controller.acciones.ListaLibrosAccion;
import es.avalon.web.controller.acciones.MostrarCapitulosDeLibro;
import es.avalon.web.controller.acciones.OrdenarCapituloPorCampoAccion;
import es.avalon.web.controller.acciones.OrdenarLibroAccion;
import es.avalon.web.controller.acciones.SalvarCapituloAccion;
import es.avalon.web.controller.acciones.SalvarLibroAccion;
import es.avalon.web.controller.acciones.SearchLibroAccion;
import es.avalon.web.controller.acciones.searchCapituloAccion;




/**
 * Servlet implementation class ServletControladorFrontal
 */
public class ServletControladorFrontal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ConfiguracionSpring.class);
		context.refresh();
		
	
		String tipoAccion = request.getParameter("accion");
		Accion accion = null;
		
		if (tipoAccion == null || tipoAccion.equals("")) {
				
			//accion = new ListaLibrosAccion();
			accion = context.getBean(ListaLibrosAccion.class);
		
	}else {

			if (tipoAccion.equals("formularioInsertar")) {

				System.out.println("******************* LLEGA 1");
				//accion = new FormularioInsertar();
				accion = context.getBean(FormularioInsertar.class);
		
			} else if (tipoAccion.equals("insertar")) {
	
				//accion = new InsertarLibroAccion();
				accion = context.getBean(InsertarLibroAccion.class);
				
			} else if (tipoAccion.equals("borrar")) {

				
				//accion = new DeleteLibroAccion();
			accion = context.getBean(DeleteLibroAccion.class);
				
			}else if (tipoAccion.equals("editarFormulario")) {
				System.out.println("*************** Entraaaaaaa   ");
				accion = new FormularioEditar();
			
				accion = context.getBean(FormularioEditar.class);
			
			}else if (tipoAccion.equals("salvar")) {

			 // accion = new SalvarLibroAccion();
			accion = context.getBean(SalvarLibroAccion.class);
				
			}else if (tipoAccion.equals("searchLibro")) {

				  //accion = new SearchLibroAccion();
				accion = context.getBean(SearchLibroAccion.class);
					
				}else if (tipoAccion.equals("titulo") || tipoAccion.equals("paginas") || tipoAccion.equals("autor")) {

				 // accion = new OrdenarLibroAccion();
				   accion = context.getBean(OrdenarLibroAccion.class); 
					
				}else if (tipoAccion.equals("listaCapitulos")) {

					//accion = new ListaCapitulosAccion();
					accion = context.getBean(ListaCapitulosAccion.class);
				}else if (tipoAccion.equals("envioLibro")) {

					//accion = new MostrarCapitulosDeLibro();
					accion = context.getBean(MostrarCapitulosDeLibro.class);
					
					}else if (tipoAccion.equals("formularioInsertCapitulo")) {
						
						//accion = new FormularioInsertarCapitulos();
						accion = context.getBean(FormularioInsertarCapitulos.class);
						
					}else if (tipoAccion.equals("insertarCapitulo")) {

						//accion = new InsertarCapituloAccion();
					
					}else if (tipoAccion.equals("borrarCapitulo")) {

						//accion = new DeleteCapituloAccion();
					
					}else if (tipoAccion.equals("editarCapitulo")) {

						//accion = new FormularioEditarCapitulo();
					
					}else if (tipoAccion.equals("salvarCapitulo")) {

						//accion = new SalvarCapituloAccion();
					
					}else if (tipoAccion.equals("searchCapitulo")) {

						  //accion = new searchCapituloAccion();		    
							
						}else if (tipoAccion.equals("ordenarCapitulosPorCampo")) {

						 // accion = new OrdenarCapituloPorCampoAccion();		    
							
						}


	}
		accion.ejecutar(request, response);
}}
