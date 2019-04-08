package entidades;

import java.util.List;

public class Pizza {
	private List<String> ingedientes;
	private String tam;

	public List<String> getIngedientes() {
		return ingedientes;
	}

	public void setIngedientes(List<String> ingedientes) {
		this.ingedientes = ingedientes;
	}

	public String getTam() {
		return tam;
	}

	public void setTam(String tam) {
		this.tam = tam;
	}

	@Override
	public String toString() {
		return "Pizza [ingedientes=" + ingedientes + ", tam=" + tam + "]";
	}
}
