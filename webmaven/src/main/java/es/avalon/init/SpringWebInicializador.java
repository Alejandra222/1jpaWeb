package es.avalon.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import es.avalon.configuracion.ConfiguracionSpring;


	public class SpringWebInicializador implements WebApplicationInitializer {
		 
		//AÑADIMOS AL pom.xml LA DEPENENCIA spring-webmvc PARA PODER IMPORTAR WebApplicationInitializer
	    public void onStartup(ServletContext contenedor) throws ServletException {
	 
	     //DA DE ALTA DINAMICAMENTE UN SERVLET PARA SPRING 
	        AnnotationConfigWebApplicationContext contexto = new AnnotationConfigWebApplicationContext();
	        contexto.register(ConfiguracionSpring.class);
	        contexto.setServletContext(contenedor);
	 
	        ServletRegistration.Dynamic servlet = contenedor.addServlet("dispatcher", new DispatcherServlet(contexto));
	        servlet.setLoadOnStartup(1);
	        servlet.addMapping("/");
	    }
}
