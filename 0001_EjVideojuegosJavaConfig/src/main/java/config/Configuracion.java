package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Configuration;

import modelo.entidades.Videojuego;
import modelo.negocio.GestorVideojuegos;
import persistencia.DaoVideojuego;
import vista.EntradaSalida;

@Configuration
public class Configuracion {

	@Bean
	@Scope("prototype")
	public Videojuego videojuego() {
		return new Videojuego();
	}
	
	@Bean
	public DaoVideojuego daoVideojuego() {
		return new DaoVideojuego();
	}
	
	@Bean("ge")
	public GestorVideojuegos gestorVideojuegos(DaoVideojuego daoVideojuego, Videojuego videojuego) {
		GestorVideojuegos ge = new GestorVideojuegos();
		ge.setDaoVideojuego(daoVideojuego);
		ge.setVideojuego(videojuego);
		return ge;
	}
	
	@Bean
	public EntradaSalida entradaSalida(@Qualifier("ge") GestorVideojuegos gestorVideojuegos) {
		EntradaSalida io = new EntradaSalida();
		io.setGe(gestorVideojuegos);
		return io;
	}
}
