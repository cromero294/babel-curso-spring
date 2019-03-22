package ejercicio01;

public class Habitacion {
	private double metros;
	private String tipo;
	
	public Habitacion(double metros, String tipo) {
		super();
		this.metros = metros;
		this.tipo = tipo;
	}

	public double getMetros() {
		return metros;
	}

	public void setMetros(double metros) {
		this.metros = metros;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Habitacion [metros=" + metros + ", tipo=" + tipo + "]";
	}
	
}
