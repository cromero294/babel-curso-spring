package _03_Sincronizaciones;

public class Obrero implements Runnable{
	private String nombre;
	private int metrosIniciales;
	private int metrosFinales;
	private Silla silla;
	
	public Obrero(String nombre, int metrosIniciales, int metrosFinales, Silla silla) {
		this.nombre = nombre;
		this.metrosIniciales = metrosIniciales;
		this.metrosFinales = metrosFinales;
		this.silla = silla;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void construirValla() {
		for(int i = this.metrosIniciales; i < this.metrosFinales; i++) {
			System.out.println("Obrero " + this.nombre + " poniendo ladrillos en el metro: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(i % 10 == 0) {
				this.silla.oscuparSilla(this);
			}
		}
	}

	@Override
	public void run() {
		this.construirValla();
	}

}
