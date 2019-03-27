package daos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entidades.Coche;

public class ListaCoches {
	private static List<Coche> listaCoches = new ArrayList<Coche>();
	
	public List<Coche> getListaCoches() {
		return listaCoches;
	}
	
	public List<Coche> getListaCochesMatricula() {
		Collections.sort(listaCoches);
		
		return listaCoches;
	}
	
	public List<Coche> getListaCochesMarca() {
		Collections.sort(listaCoches, new Comparator<Coche>() {
			@Override
			public int compare(Coche o1, Coche o2) {
				return o1.getMarca().compareTo(o2.getMarca());
			}
			
		});
		
		return listaCoches;
	}
	
	public List<Coche> getListaCochesKilometros() {
		Collections.sort(listaCoches, new Comparator<Coche>() {
			@Override
			public int compare(Coche o1, Coche o2) {
				return (int)(o1.getKilometros() - o2.getKilometros());
			}
			
		});
		
		return listaCoches;
	}
	
	public boolean addCoche(Coche coche) {
		if(listaCoches.contains(coche)) {
			return false;
		}
		
		listaCoches.add(coche);
		
		return true;
	}
}
