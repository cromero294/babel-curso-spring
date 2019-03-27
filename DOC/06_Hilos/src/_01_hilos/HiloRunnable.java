package _01_hilos;

public class HiloRunnable implements Runnable{
	
	private String nombreHilo;
	private int numeroIteraciones;
	
	public HiloRunnable (String nombreHilo, int numeroIteraciones) {
		this.nombreHilo = nombreHilo;
		this.numeroIteraciones = numeroIteraciones;
	}

	@Override
	public void run() {
		System.out.println("Arrancando el hilo " + nombreHilo);
		
		for(int i = 1; i <= numeroIteraciones;i++) {
			System.out.println(nombreHilo + " - " + i);
			//uno de los metodos es sleep()
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Hilo " + nombreHilo + " finalizando....");
	}
	
	
}
