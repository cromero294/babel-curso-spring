package main;

import java.util.*;

import entidades.Directivo;
import entidades.Empleado;
import entidades.Jefe;
import entidades.Trabajador;

public class Sistema {
	private Map<String,Empleado> empleados = new HashMap<String,Empleado>();
	
	public Sistema(Map<String,Empleado> empleados) {
		this.empleados = empleados;
	}

	public Map<String,Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Map<String,Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public void altaEmpleado() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Por favor, introduce tipo de empleado (Directivo, Jefe o Trabajador): ");
		String tipo = sc.nextLine();
		
		System.out.println("Por favor, introduce nombre de empleado: ");
		String nombre = sc.nextLine();
		
		System.out.println("Por favor, introduce nómina base del empleado: ");
		double nomina = sc.nextDouble();
		
		if(tipo.equals("Jefe")) {
			System.out.println("Por favor, introduce incentivo: ");
			double incentivo = sc.nextDouble();
			
			this.empleados.put(nombre, new Jefe(nombre, nomina, incentivo));
		}else if(tipo.equals("Directivo")) {
			System.out.println("Esta es la lista de empleados, ¿quieres añadir empleados al nuevo directivo?");
			this.listarEmpleados();
			String nomEmp = null;
			int siono;
			List<Empleado> empsDirectivo = new ArrayList<Empleado>();
			
			do {
				System.out.println("Introduce nombre del empleado que quieres añadir: ");
				nomEmp = sc.nextLine();

				empsDirectivo.add(this.empleados.get(nomEmp));
				
				System.out.println("¿Quieres añadir más empleados? \n\t1. Sí.\n\t2. No.");
				siono = sc.nextInt();
			}while(siono == 1);
			
			this.empleados.put(nombre, new Directivo(nombre, nomina, empsDirectivo));
		}else {
			this.empleados.put(nombre, new Trabajador(nombre, nomina));
		}
	}
	
	public void bajaEmpleado() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Por favor, introduce nombre de empleado: ");
		String nombre = sc.nextLine();
		
		this.empleados.remove(nombre);
	}
	
	public void listarEmpleados() {
		for(Empleado emp : this.empleados.values()) {
			System.out.println("(" + emp.getNombre() + ", " + emp.calcularSueldo() + ")");
		}
	}
	
}
