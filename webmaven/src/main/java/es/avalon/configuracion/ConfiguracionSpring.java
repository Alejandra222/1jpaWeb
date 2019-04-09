package es.avalon.configuracion;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan("es.avalon")
@EnableTransactionManagement
public class ConfiguracionSpring {
	
	//pull de conexión con bd en Spring o JPA
	
	/* necesitamos añadir en el pom.xml del proyecto jpa001Maven
	 * 
	 *    <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.1.6.RELEASE</version>
</dependency>

*/
	@Bean
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost/avalon?serverTimezone=UTC");
	    dataSource.setUsername( "root" );
	    dataSource.setPassword( "" );
	    return dataSource;
	    
	    
	    
	}
	
	
	
/*
 * 
 * necesitamos añadir en el pom.xml del proyecto jpa001Maven
 * 
 *   <!-- https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa -->
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-jpa</artifactId>
    <version>2.1.6.RELEASE</version>
</dependency>

*/	
	
	
	
@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig{
 
   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean em 
        = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource());
      em.setPackagesToScan(new String[] { "es.avalon.jpa.negocio" });
      //hace referencia al proyecto jpa001Maven->src/main/java->es.avalon.jpa.negocio
      
      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
      em.setJpaProperties(additionalProperties());
 
      return em;
   }
   
   @Bean
   public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
       JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(emf);
    
       return transactionManager;
   }
    
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
       return new PersistenceExceptionTranslationPostProcessor();
   }
   
   
   Properties additionalProperties() {
	    Properties properties = new Properties();
	    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        
	    return properties;
	}
   
    
   // ...
 
}
	
	/*
	@Bean
	public Persona getPersona() {
		
		return new Persona("juan1");
	}

	@Bean
	IServicioMensaje getServicioMensaje() {
		return new ServicioMensaje();
		
	}
	
	@Bean
	SpringVersionRepositorio getSpringVersionRepositorio() {
		return new SpringVersionRepositorio();
	}
	
	@Bean
	SaludoRepositorio getSaludoRepositorio() {
		return new SaludoRepositorio();
	}
	
	
	
	@Bean
	ServicioFachada getServicioFachada() {
		ServicioFachada f = new ServicioFachada();
		f.setRepoSaludo(getSaludoRepositorio());
		f.setRepoVersion(getSpringVersionRepositorio());
		return f;
	}*/
}
