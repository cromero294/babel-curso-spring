package ejercicio01;

import ejercicio01.Direccion;

public class Persona {
	private String nombre;
	private double altura;
	private int edad;
	private Direccion direccion;
	
	public Persona(String nombre, double altura, int edad, Direccion d) {
		this.altura = altura;
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = d;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", altura=" + altura + ", edad=" + edad + ", direccion=" + direccion + "]";
	}

}
