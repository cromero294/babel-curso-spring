package entidades;

import java.util.ArrayList;
import java.util.List;

public class Directivo extends Empleado{

	public static double extra = 5.0;
	private List<Empleado> empleados = new ArrayList<Empleado>();

	public Directivo(String nombre, double salarioBase) {
		super(nombre, salarioBase);
	}
	
	public Directivo(String nombre, double salarioBase, List<Empleado> empleados) {
		super(nombre, salarioBase);
		this.empleados = empleados;
	}
	
	public void addEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
	}
	
	@Override
	public double calcularSueldo() {
		return this.getSalarioBase() + this.empleados.size() * Directivo.extra;
	}

}
