package entidades;

public class Coche implements Comparable<Coche>{
	private String matricula;
	private String marca;
	private String modelo;
	private double kilometros;
	
	public String getMatricula() {
		return matricula;
	}
	public boolean setMatricula(String matricula) {
		if(matricula.length() == 7) this.matricula = matricula;
		else return false;
		
		return true;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getKilometros() {
		return kilometros;
	}
	public void setKilometros(double kilometros) {
		this.kilometros = kilometros;
	}
	
	
	
	@Override
	public String toString() {
		return "(matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", kilometros="
				+ kilometros + ")\n";
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public int compareTo(Coche o) {
		return this.matricula.compareTo(o.getMatricula());
	}
}
