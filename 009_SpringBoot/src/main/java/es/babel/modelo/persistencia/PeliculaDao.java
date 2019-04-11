package es.babel.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import es.babel.modelo.entidades.Pelicula;

// Pelicula seria el tipo de dato con el que vamos a trabajar
// Integer seria el tipo de clave primaria de la tabla peliculas
public interface PeliculaDao extends JpaRepository<Pelicula, Integer>{
	// Aqui prima la convencion de frente a la programacion y la configuracion
	public Pelicula findByTitulo(String titulo);
}
