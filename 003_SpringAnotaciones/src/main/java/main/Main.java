package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;

public class Main {
	private static ApplicationContext context = null;
	
	static {
		context = new ClassPathXmlApplicationContext("beans1.xml");
	}

	public static void main(String[] args) {
		Pelicula p = context.getBean("pelicula", Pelicula.class);
		p.setTitulo("La guerra de las galaxias");
		p.setGenero("Sci-fi");
		p.setYear(1975);
		//p.getDirector().setNombre("Pinocho");
		System.out.println(p);
		
		GestorPelicula gp = context.getBean("gestorPelicula", GestorPelicula.class);
		gp.insertar(p);
		
		p = context.getBean("pelicula", Pelicula.class);
		p.setTitulo("La guerra de las galaxias segunda parte");
		p.setGenero("Sci-fi");
		p.setYear(1980);
		//p.getDirector().setNombre("Pinocho");
		
		gp.insertar(p);
		
		p = context.getBean("pelicula", Pelicula.class);
		p.setTitulo("La guerra de las galaxias terera parte");
		p.setGenero("Sci-fi");
		p.setYear(1985);
		//p.getDirector().setNombre("Pinocho");
		
		gp.insertar(p);
		
		System.out.println(gp.listar());
	}

}
