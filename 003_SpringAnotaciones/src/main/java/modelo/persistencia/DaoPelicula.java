package modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import modelo.entidades.Pelicula;

@Repository
public class DaoPelicula {
	private List<Pelicula> lista = new ArrayList<Pelicula>();
	
	public boolean add(Pelicula p) {
		return this.lista.add(p);
	}
	
	public List<Pelicula> listar() {
		return this.lista;
	}
}
