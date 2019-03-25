package main;

import java.util.*;

import entidades.*;

public class Main {

	public static void main(String[] args) {
		Directivo emp1 = new Directivo("Roberto", 2000.0);
		Empleado emp2 = new Jefe("Julia", 1500.0, 300.0);
		Empleado emp3 = new Trabajador("Mario", 1200.0);
		Empleado emp4 = new Trabajador("Luisa", 1200.0);
		Empleado emp5 = new Trabajador("Pepito", 1200.0);
		
		emp1.addEmpleado(emp2);
		emp1.addEmpleado(emp3);
		emp1.addEmpleado(emp4);
		
		Map<String,Empleado> empleados = new HashMap<String,Empleado>();
		empleados.put(emp1.getNombre(), emp1);
		empleados.put(emp2.getNombre(), emp2);
		empleados.put(emp3.getNombre(), emp3);
		empleados.put(emp4.getNombre(), emp4);
		empleados.put(emp5.getNombre(), emp5);
		
		Sistema sistema = new Sistema(empleados);
		
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		do {
			System.out.println("Introduce qué acción quieres realizar: \n\t1. Listar empleados.\n\t2. Dar de alta un empleado.\n\t3. Dar de baja un empleado.\n\t4. Salir.");
			opcion = sc.nextInt();
			
			switch(opcion) {
				case 1:
					sistema.listarEmpleados();
					break;
				case 2:
					sistema.altaEmpleado();
					break;
				case 3:
					sistema.bajaEmpleado();
					break;
				case 4:
					break;
			}
			
		}while(opcion != 4);
		
	}

}
