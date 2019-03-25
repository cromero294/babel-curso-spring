package entidades;

public class Jefe extends Empleado{
	
	private double incentivos;

	public Jefe(String nombre, double salarioBase, double incentivos) {
		super(nombre, salarioBase);
		this.incentivos = incentivos;
	}

	@Override
	public double calcularSueldo() {
		return this.getSalarioBase() + this.incentivos;
	}

}
