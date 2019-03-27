package _01_Hilos;

public class Main {

	public static void main(String[] args) {
		HiloThread hilo1 = new HiloThread("Hilo 1", 25);
		HiloThread hilo2 = new HiloThread("Hilo 2", 20);
		HiloThread hilo3 = new HiloThread("Hilo 3", 15);
		
		hilo1.setPriority(1); // No funciona bien
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		System.out.println("Main finalizado");
	}

}
