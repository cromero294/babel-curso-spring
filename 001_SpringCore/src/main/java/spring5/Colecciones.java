package spring5;

import java.util.*;

public class Colecciones {
	private List<String> listaString;
	private Set<String> conjuntoString;
	private Map<Integer, String> mapaString;
	private List<Coche> listaCoches;
	private Map<Integer, Coche> mapaCoches;
	
	public List<String> getListaString() {
		return listaString;
	}
	public void setListaString(List<String> listaString) {
		this.listaString = listaString;
	}
	public Set<String> getConjuntoString() {
		return conjuntoString;
	}
	public void setConjuntoString(Set<String> conjuntoString) {
		this.conjuntoString = conjuntoString;
	}
	public Map<Integer, String> getMapaString() {
		return mapaString;
	}
	public void setMapaString(Map<Integer, String> mapaString) {
		this.mapaString = mapaString;
	}
	public List<Coche> getListaCoches() {
		return listaCoches;
	}
	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}
	public Map<Integer, Coche> getMapaCoches() {
		return mapaCoches;
	}
	public void setMapaCoches(Map<Integer, Coche> mapaCoches) {
		this.mapaCoches = mapaCoches;
	}
}
