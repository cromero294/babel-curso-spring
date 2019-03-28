package modelo.negocio;

import java.util.List;

import modelo.entidades.Persona;
import modelo.persistencia.DaoPersona;
import modelo.persistencia.DaoPersonaMySql;

public class GestorPersona {
	private DaoPersona daoPersona;
	
	public boolean alta(Persona p) {
		daoPersona = new DaoPersonaMySql();
		return daoPersona.alta(p);
	}
	
	public boolean eliminar(int id) {
		daoPersona = new DaoPersonaMySql();
		return daoPersona.eliminar(id);
	}
	
	public boolean update(Persona p) {
		daoPersona = new DaoPersonaMySql();
		return daoPersona.update(p);
	}
	
	public Persona obtener(int id) {
		daoPersona = new DaoPersonaMySql();
		return daoPersona.obtener(id);
	}
	
	public List<Persona> listar() {
		daoPersona = new DaoPersonaMySql();
		return daoPersona.listar();
	}
}
