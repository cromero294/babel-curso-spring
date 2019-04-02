package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import modelo.entidades.Pelicula;
import modelo.persistencia.DaoPelicula;

@Service
public class GestorPelicula { // El id se dara de alta en Spring en notacion lowerCamelCase
	// Con anotaciones no necesitamos que los atributos sean propiedades, spring lo hace a traves de reflection.
	
	@Autowired
	@Qualifier("daoPelicula")
	private DaoPelicula daoPelicula;

	public boolean insertar(Pelicula p) {
		if(!"".equals(p.getTitulo())) {
			return daoPelicula.add(p);
		}
		
		return false;
	}
	
	public List<Pelicula> listar() {
		return daoPelicula.listar();
	}
	
	public DaoPelicula getDaoPelicula() {
		return daoPelicula;
	}

	public void setDaoPelicula(DaoPelicula daoPelicula) {
		this.daoPelicula = daoPelicula;
	}
}
