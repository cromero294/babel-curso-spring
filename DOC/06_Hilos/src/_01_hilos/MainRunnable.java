package _01_hilos;

public class MainRunnable {

	public static void main(String[] args) {
		HiloRunnable hilo1 = new HiloRunnable("Hilo 1", 30);
		HiloRunnable hilo2 = new HiloRunnable("Hilo 2", 25);
		HiloRunnable hilo3 = new HiloRunnable("Hilo 3", 40);
		
		Thread t1 = new Thread(hilo1);
		Thread t2 = new Thread(hilo2);
		Thread t3 = new Thread(hilo3);
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("Acabando el hilo principal");
	}

}
