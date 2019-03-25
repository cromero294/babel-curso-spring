package entidades;

public class Trabajador extends Empleado{

	public Trabajador(String nombre, double salarioBase) {
		super(nombre, salarioBase);
	}

	@Override
	public double calcularSueldo() {
		return this.getSalarioBase();
	}

}
