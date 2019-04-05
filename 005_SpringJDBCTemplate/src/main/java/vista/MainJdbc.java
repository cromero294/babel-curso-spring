package vista;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Configuracion;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;

public class MainJdbc {

	private static ApplicationContext context;
	
	static {
		context = new AnnotationConfigApplicationContext(Configuracion.class);
	}
	
	public static void main(String[] args) {
		GestorPelicula gp = context.getBean("gestorPelicula", GestorPelicula.class);
		Pelicula p = context.getBean("pelicula", Pelicula.class);
		p.setTitulo("La guerra de los mundos");
		p.setDirector("Bob el silencioso");
		p.setGenero("Sci-fi");
		p.setYear(2001);
		
		gp.insertar(p);
		
		p.setId(7);
		p.setTitulo("Mallrats");
		
		gp.modificar(p);
		
		Pelicula p2 = gp.buscar(7);
		System.out.println(p2);
		
		System.out.println(gp.listar());
		
		gp.borrar(7);
		
		System.out.println(gp.listar());
	}

}
