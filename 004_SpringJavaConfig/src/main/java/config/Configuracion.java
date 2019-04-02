package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import modelo.entidades.Director;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;
import modelo.persistencia.DaoPelicula;

/**
 * Con esta configuracion le decimos a Spring (en caso de que sea escaneada)
 * que esta va a llevar la creacion de beans de spring.
 * @author mario.calle
 *
 */
@Configuration
// @ComponentScan("modelo") // <context:component-scan>
public class Configuracion {
	/**
	 * Con esta anotacion estamos diciendo que este metodo va a llevar la
	 * creacion de un objeto en el contenedor de spring.
	 */
	@Bean
	@Scope("prototype")
	public Pelicula pelicula(Director director) {
		// Por defecto va a hacer un autowire por tipo al parametro de entrada director,
		// si no existe, director sera null.
		Pelicula p = new Pelicula();
		p.setDirector(director);
		return p;
	}
	
	@Bean
	@Scope("prototype")
	public Director director() {
		Director d = new Director();
		d.setNombre("George Lucas");
		return d;
	}
	
	@Bean("daoPelicula") // Podemos cambiar el id del bean
	public DaoPelicula crearDaoPelicula() {
		DaoPelicula daoPelicula = new DaoPelicula();
		return daoPelicula;
	}
	
	// Si tuvieramos muchos tipos de dao con @Qualifier le podemos decir cual queremos utilizar
	@Bean
	public GestorPelicula gestorPelicula(@Qualifier("daoPelicula") DaoPelicula daoPelicula) {
		GestorPelicula gp = new GestorPelicula();
		gp.setDaoPelicula(daoPelicula);
		return gp;
	}
}
