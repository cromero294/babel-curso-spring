package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidades.Pelicula;
import modelo.persistencia.PeliculaDao;

@Service
public class GestorPelicula {
	
	@Autowired
	PeliculaDao peliculaDao;
	
	@Transactional
	public Pelicula insertar(Pelicula p) {
		return peliculaDao.save(p);
	}
	
	@Transactional
	public Pelicula modificar(Pelicula p) {
		return peliculaDao.save(p);
	}
	
	@Transactional
	public void borrar(int id) {
		peliculaDao.delete(id);
	}
	
	public Pelicula buscar(int id) {
		return peliculaDao.findOne(id);
	}
	
	public List<Pelicula> listar() {
		return peliculaDao.findAll();
	}
}
