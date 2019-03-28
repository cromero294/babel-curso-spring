package modelo.persistencia;

import java.util.List;

import modelo.entidades.Persona;

public interface DaoPersona {
	boolean alta(Persona p);
	boolean eliminar(int id);
	boolean update(Persona p);
	Persona obtener(int id);
	List<Persona> listar();
}
