import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cfg.Configuracion;
import modelo.entidades.Pelicula;
import modelo.persistencia.PeliculaDao;

public class mainJPA {

	private static ApplicationContext context = null;
	
	static {
		// context = new ClassPathXmlApplicationContext("beans1.xml");
		context = new AnnotationConfigApplicationContext(Configuracion.class);
	}

	public static void main(String[] args) {
		PeliculaDao peliculaDao = context.getBean("peliculaDao",PeliculaDao.class);
		
		Pelicula p = new Pelicula();
		p.setTitulo("La guerra de los mundos");
		p.setDirector("Stanley Kubrick");
		p.setYear(2000);
		
		peliculaDao.save(p);
		
		p = new Pelicula();
		p.setTitulo("El dia de la bestia");
		p.setDirector("Amenabar");
		p.setYear(1991);
		
		peliculaDao.save(p);
		
		List<Pelicula> peliculas = peliculaDao.findAll();
		
		System.out.println(peliculas);
		
		Pelicula p1 = peliculaDao.findOne(1);
		p1 = peliculaDao.findByTitulo("La guerra de los mundos");
		System.out.println(p1);
	}

}
