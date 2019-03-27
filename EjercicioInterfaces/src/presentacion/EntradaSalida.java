package presentacion;

import java.util.List;
import java.util.Scanner;

import entidades.Coche;
import modelo.Gestor;

public class EntradaSalida {
	public void menu() {
		Scanner sc = new Scanner(System.in);
		Gestor ge = new Gestor();
		int opcion = 0;
		
		do {
			System.out.println("¿Qué te gustaría hacer?");
			System.out.println("\t1. Listar coches.");
			System.out.println("\t2. Listar coches ordenados por matrícula.");
			System.out.println("\t3. Listar coches ordenados por marca.");
			System.out.println("\t4. Listar coches ordenados por kilómetros.");
			System.out.println("\t5. Añadir coche.");
			System.out.println("\t6. Salir.");
			
			opcion = sc.nextInt();
			
			switch(opcion) {
				case 1:
					this.listar(ge.getListaCoches());
					break;
				case 2:
					this.listar(ge.getListaCochesMatricula());
					break;
				case 3:
					this.listar(ge.getListaCochesMarca());
					break;
				case 4:
					this.listar(ge.getListaCochesKilometros());
					break;
				case 5:
					this.addCoche();
					break;
			}
		}while(opcion != 6);
	}
	
	public boolean addCoche() {
		Scanner sc = new Scanner(System.in);
		String matricula = null;
		String marca = null;
		String modelo = null;
		double kilometros = 0.0;
		
		Gestor ge = new Gestor();
		
		System.out.println("¿Matrícula del coche?");
		matricula = sc.nextLine();
		
		System.out.println("¿Marca del coche?");
		marca = sc.nextLine();
		
		System.out.println("¿Modelo del coche?");
		modelo = sc.nextLine();
		
		System.out.println("¿Kilómetros del coche?");
		kilometros = sc.nextDouble();
		
		return ge.addCoche(matricula, marca, modelo, kilometros);
	}
	
	public void listar(List<Coche> listaCoches) {
		for(Coche coche : listaCoches) {
			System.out.println(coche.toString());
		}
	}
}
