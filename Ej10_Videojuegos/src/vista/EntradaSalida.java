package vista;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import modelo.negocio.GestorVideojuegos;

public class EntradaSalida {
	public void menu() {
		GestorVideojuegos ge = GestorVideojuegos.getInstance();
		Scanner sc = new Scanner(System.in);
		
		int opcion = 0;
		
		do {
			System.out.println("¿Qué quieres hacer?");
			System.out.println("\t0. Crear backup.");
			System.out.println("\t1. Crear videojuego.");
			System.out.println("\t2. Quitar videojuego.");
			System.out.println("\t3. Modificar videojuego por id.");
			System.out.println("\t4. Buscar videojuego por nombre.");
			System.out.println("\t5. Buscar videojuego por id.");
			System.out.println("\t6. Eliminar juego por id.");
			System.out.println("\t7. Listar juegos.");
			System.out.println("\t8. Calcular valoraciones medias.");
			System.out.println("\t9. Calcular precio medio.");
			System.out.println("\t10. Salir.");
			
			opcion = sc.nextInt();
			switch(opcion) {
				case 0:
					Thread t = new Thread(ge);
					t.start();
					break;
				case 1:
					crearVideojuego();
					break;
				case 2:
					quitarVideojuego();
					break;
				case 3:
					modificarVideojuego();
					break;
				case 4:
					buscarVideojuego();
					break;
				case 5:
					buscarVideojuegoId();
					break;
				case 6:
					quitarVideojuegoId();
					break;
				case 7:
					listarVideojuegos();
					break;
				case 8:
					calcularValoracionMedia();
					break;
				case 9:
					calcularPrecioMedio();
					break;
			}
		}while(opcion != 10);
	}

	private void calcularValoracionMedia() {
		GestorVideojuegos ge = GestorVideojuegos.getInstance();
		
		System.out.println(ge.valoracionMedia());
	}
	
	private void calcularPrecioMedio() {
		GestorVideojuegos ge = GestorVideojuegos.getInstance();
		
		System.out.println(ge.precioMedia());
	}

	private void listarVideojuegos() {
		GestorVideojuegos ge = GestorVideojuegos.getInstance();
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> videojuegos = ge.listar();
		int opcion;
		
		for(Entry videojuego : videojuegos.entrySet()) {
			System.out.println("(" + videojuego.getKey() + ", " + videojuego.getValue() + ")");
		}
		
		System.out.println("¿Quieres borrar o modificar algún elemento de la lista?");
		System.out.println("\t1. Borrar.");
		System.out.println("\t2. Modificar.");
		System.out.println("\t3. Volver al menú.");
		opcion = sc.nextInt();
		
		switch(opcion) {
		case 1:
			quitarVideojuegoId();
			break;
		case 2:
			modificarVideojuego();
			break;
		}
	}

	private void modificarVideojuego() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el id del juego que quieres modificar: ");
		int id = sc.nextInt();
		
		modificarVideojuego(id);
	}
	
	private void modificarVideojuego(int id) {
		GestorVideojuegos ge = GestorVideojuegos.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el nombre del videojuego*: ");
		String nombre = sc.nextLine();
		
		System.out.println("Introduce el nombre de la compañía*: ");
		String company = sc.nextLine();
		
		System.out.println("Introduce la valoración del juego (del 0 al 10, -1 para dejar el campo vacío): ");
		int valoracion = -1;
		
		try {
			valoracion = sc.nextInt();			
		} catch(InputMismatchException e) {
			System.out.println("[ERROR] La valoración debe ser un entero del 0 al 10.");
			return;
		}
		
		System.out.println("Introduce el precio del juego (decimales separados por coma, -1 para dejar el campo vacío): ");
		double precio = -1;
		
		try {
			precio = sc.nextDouble();			
		} catch(InputMismatchException e) {
			System.out.println("[ERROR] El precio debe ser introducido con los decimales separados por una coma.");
			return;
		}

		
		ge.modificar(nombre, company, valoracion, precio, id);
	}

	private void buscarVideojuego() {
		GestorVideojuegos ge = GestorVideojuegos.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el nombre del videojuego que quieres buscar: ");
		String nombre = sc.nextLine();
		
		if(ge.buscar(nombre) != null) {
			System.out.println(ge.buscar(nombre));
			
			System.out.println("¿Quieres hacer algo con este juego?");
			System.out.println("\t1. Borrar.");
			System.out.println("\t2. Modificar.");
			System.out.println("\t3. Volver al menú.");
			
			int opcion = sc.nextInt();
			
			switch(opcion) {
				case 1:
					quitarVideojuego(nombre);
					break;
				case 2:
					modificarVideojuego(ge.buscar(nombre).getId());
					break;
			}
		}
	}
	
	private void buscarVideojuegoId() {
		GestorVideojuegos ge = GestorVideojuegos.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el ID del videojuego que quieres buscar: ");
		int id = sc.nextInt();
		
		if(ge.buscar(id) != null) {
			System.out.println(ge.buscar(id));
			
			System.out.println("¿Quieres hacer algo con este juego?");
			System.out.println("\t1. Borrar.");
			System.out.println("\t2. Modificar.");
			System.out.println("\t3. Volver al menú.");
			
			int opcion = sc.nextInt();
			
			switch(opcion) {
				case 1:
					quitarVideojuego(ge.buscar(id).getNombre());
					break;
				case 2:
					modificarVideojuego(ge.buscar(id).getId());
					break;
			}
		}
	}
	
	private void quitarVideojuego() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el nombre del videojuego que quieres eliminar: ");
		String nombre = sc.nextLine();
		
		quitarVideojuego(nombre);
	}

	private void quitarVideojuego(String nombre) {
		GestorVideojuegos ge = GestorVideojuegos.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Estás seguro de que quieres eliminar el juego " + nombre + "? s/n");
		String opcion = sc.next();
		
		if(opcion.equals("s")) {
			ge.eliminar(nombre);
		}
	}
	
	private void quitarVideojuegoId() {
		GestorVideojuegos ge = GestorVideojuegos.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el ID del videojuego que quieres eliminar: ");
		int id = sc.nextInt();
		
		try {
			String nombre = ge.buscar(id).getNombre();
		}catch(NullPointerException e) {
			System.out.println("No existe el videojuego especificado.");
			return;
		}
		
		System.out.println("¿Estás seguro de que quieres eliminar el juego " + ge.buscar(id).getNombre() + "? s/n");
		String opcion = sc.next();
		
		if(opcion.equals("s")) {
			ge.eliminar(id);
		}
	}

	private void crearVideojuego() {
		GestorVideojuegos ge = GestorVideojuegos.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el nombre del videojuego*: ");
		String nombre = sc.nextLine();
		
		System.out.println("Introduce el nombre de la compañía*: ");
		String company = sc.nextLine();
		
		System.out.println("Introduce la valoración del juego (del 0 al 10, -1 para dejar el campo vacío): ");
		int valoracion = -1;
		
		try {
			valoracion = sc.nextInt();			
		} catch(InputMismatchException e) {
			System.out.println("[ERROR] La valoración debe ser un entero del 0 al 10.");
			return;
		}
		
		System.out.println("Introduce el precio del juego (decimales separados por coma, -1 para dejar el campo vacío): ");
		double precio = -1;
		
		try {
			precio = sc.nextDouble();			
		} catch(InputMismatchException e) {
			System.out.println("[ERROR] El precio debe ser introducido con los decimales separados por una coma.");
			return;
		}

		if(!ge.crear(nombre, company, valoracion, precio)) {
			System.out.println("[ERROR] Los campos con * son obligatorios.");
		}
		
	}
}
