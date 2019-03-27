package modelo;
import java.util.List;

import daos.ListaCoches;
import entidades.Coche;

public class Gestor {
	
	public List<Coche> getListaCoches() {
		return new ListaCoches().getListaCoches();
	}
	
	public List<Coche> getListaCochesMatricula() {
		return new ListaCoches().getListaCochesMatricula();
	}
	
	public List<Coche> getListaCochesMarca() {
		return new ListaCoches().getListaCochesMarca();
	}
	
	public List<Coche> getListaCochesKilometros() {
		return new ListaCoches().getListaCochesKilometros();
	}

	public boolean addCoche(String matricula, String marca, String modelo, double kilometros) {
		Coche coche = new Coche();
		
		if(!coche.setMatricula(matricula)) {
			System.out.println("Error al introducir matrícula: Asegúrese de que la matrícula tiene 7 caracteres.");
			return false;
		}
		coche.setMarca(marca);
		coche.setModelo(modelo);
		coche.setKilometros(kilometros);
		
		new ListaCoches().addCoche(coche);
		
		return true;
	}
}
