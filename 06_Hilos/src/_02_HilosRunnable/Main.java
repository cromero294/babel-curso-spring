package _02_HilosRunnable;

public class Main {

	public static void main(String[] args) {
		HiloRunnable hilo1 = new HiloRunnable("Hilo 1", 25);
		HiloRunnable hilo2 = new HiloRunnable("Hilo 2", 20);
		HiloRunnable hilo3 = new HiloRunnable("Hilo 3", 15);
		
		Thread t1 = new Thread(hilo1);
		Thread t2 = new Thread(hilo2);
		Thread t3 = new Thread(hilo3);
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("Acabando hilo principal.");
	}

}
