package _03_Sincronizaciones;

public class Silla {
	
	// La palabra synchronized hace que cuando un hilo entre, bloque el objeto al resto de hilos.
	// Cuando el hilo salga del m�todo, los dem�s hilos despertar�n y continuar�n con su ejecuci�n.
	public synchronized void oscuparSilla(Obrero o) {
		System.out.println("Ufffffffffff, a descansar gente. Soy " + o.getNombre() + ".");
		
		try {
			Thread.sleep(5000);
			System.out.println("Ya he descansado suficiente. A volver al curro eh jaja deputamadrecompadre.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
