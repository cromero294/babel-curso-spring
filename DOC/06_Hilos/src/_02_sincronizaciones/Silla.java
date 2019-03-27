package _02_sincronizaciones;

public class Silla {
	
	private boolean ocupada;
	//la palabra synchronized hace que cuando un hilo entre
	//bloquea todo el objeto a los demas hilos
	//de tal manera que solamente pueda entrar un hilo a la vez en el objeto
	//cuando el hilo que ha bloqueado el objeto salga del metodo sincronizado
	//los demás hilos despertaran y continuaran con su ejecución
	public synchronized void ocuparSilla(Obrero o) {
		ocupada = true;
		System.out.println("Uffffff que cansado estoy");
		System.out.println("Soy el obrero " + o.getNombre() + " y me voy a sentar un poquitin...");
		
		try {
			Thread.sleep(5000);
			System.out.println(o.getNombre() + " - Ya he descansado sufiente, me voy a poner ladrillos");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		ocupada = false;
	}
	
	public boolean getOcupada() {
		return ocupada;
	}
}
