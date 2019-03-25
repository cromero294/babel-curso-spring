package entidades;

public abstract class Empleado {
	private String nombre;
	private double salarioBase;
	
	public Empleado(String nombre, double salarioBase) {
		this.setNombre(nombre);
		this.setSalarioBase(salarioBase);
	}
	
	public abstract double calcularSueldo();

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
