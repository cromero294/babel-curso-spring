package _01_Hilos;

// Una de las maneras serías extendiendo de la clase Thread
public class HiloThread extends Thread{
	
	private String nombreHilo;
	private int numeroIteraciones;
	
	public HiloThread(String nombreHilo, int numeroIteraciones) {
		this.nombreHilo = nombreHilo;
		this.numeroIteraciones = numeroIteraciones;
	}
	
	// Es el punto de entrada de ejecucion del hilo. El hilo nacerá cuando
	// ejecutemos su método start() que viene heredado de la clase Thread y muere cuando acabe run()
	// El método start ejecutará el método run pero en un hilo nuevo.
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
