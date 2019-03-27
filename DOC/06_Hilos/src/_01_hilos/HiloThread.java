package _01_hilos;

//una de las maneras de crear un hilo seria extendiendo la clase Thread
public class HiloThread extends Thread{

	private String nombreHilo;
	private int numeroIteraciones;
	
	public HiloThread(String nombreHilo, int numeroIteraciones) {
		this.nombreHilo = nombreHilo;
		this.numeroIteraciones = numeroIteraciones;
	}
	
	//Este metodo de aqui sera equivalente a un metodo main de la clase 
	//principal, dicho de otra manera, va a ser el punto de entrada de ejecución 
	//del hilo. El hilo nacera cuando ejecutemos su metodo start() que viene
	//heredado de la clase Thread, y morira cuando acabe el metodo run().
	//El metodo start() ejecutará el metodo run() pero en un hilo nuevo, diferente
	//al hilo del main
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
