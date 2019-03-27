package _02_HilosRunnable;

public class HiloRunnable implements Runnable {

	private String nombreHilo;
	private int numeroIteraciones;

	public HiloRunnable(String nombreHilo, int i) {
		this.nombreHilo = nombreHilo;
		this.numeroIteraciones = i;
	}

	@Override
	public void run() {
		System.out.println("Arrancando el hilo " + nombreHilo);
		
		for(int i = 1; i <= numeroIteraciones; i++) {
			System.out.println(nombreHilo + " - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Hilo " + nombreHilo + " finalizando...");
		
	}

}
