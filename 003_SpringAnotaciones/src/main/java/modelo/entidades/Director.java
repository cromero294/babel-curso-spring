package modelo.entidades;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Tenemos 4 tipos de estereotipos de anotaciones en Spring.
 * @Component
 * @Controller
 * @Service
 * @Repository
 * 
 * Con estas cuatro anotaciones podemos dar objetos de alta en el contenedor
 * de Spring.
 * Las diferencias son basicamente semanticas.
 * 
 * @Repository, da de alta un objeto en Spring de tipo persistencia.
 * @Service, estamos diciendo que es un objeto de negocio.
 * @Controller, lleva la logica de navegacion dentro de un modelo MVC.
 * @Component es la padre de los demas y se usa a nivel generico.
 * 
 * Inconvenientes
 * 	- Recompilar codigo cada vez que cambiemos algo.
 * 	- Con anotaciones solo se puede dar de alta un bean de un tipo a la vez.
 * 
 * @author mario.calle
 *
 */

@Component // Por defecto los estereotipos son singleton.
@Scope("prototype")
public class Director {
	private int id;
	@Value("George Lucas")
	private String nombre;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Director [id=" + id + ", nombre=" + nombre + "]";
	}
}
