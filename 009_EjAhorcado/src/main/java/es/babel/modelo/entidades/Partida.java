package es.babel.modelo.entidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Partida {
	@Autowired
	private Palabra palabra;
	private int intentos;
	
	public Palabra getPalabra() {
		return palabra;
	}
	public void setPalabra(Palabra palabra) {
		this.palabra = palabra;
	}
	public int getIntentos() {
		return intentos;
	}
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	@Override
	public String toString() {
		return "Partida [palabra=" + palabra + ", intentos=" + intentos + "]";
	}
}
