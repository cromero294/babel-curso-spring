package _03_waitnotify;

public class Productor extends Thread{

	public String nombre;
	public Cola cola;
	
	public Productor(String nombre, Cola cola){
		super();
		this.nombre = nombre;
		this.cola = cola;
	}
	
	public void run(){
		for(int a = 0;a < 10;a++){
			String mensaje = nombre + " - " + a;//Productor 1 - 2
			cola.addMensaje(mensaje);
		}
	}

}
