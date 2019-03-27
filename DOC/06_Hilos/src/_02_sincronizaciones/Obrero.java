package _02_sincronizaciones;

public class Obrero implements Runnable{

	private String nombre;
	private int metrosIniciales;
	private int metrosFinales;
	private Silla silla;
	
	public Obrero(String nombre, int metrosIniciales, int metrosFinales, Silla silla) {
		this.metrosIniciales = metrosIniciales;
		this.metrosFinales = metrosFinales;
		this.nombre = nombre;
		this.silla = silla;
	}
	
	public void contruirValla() {
		for(int i = metrosIniciales; i <= metrosFinales;i++) {
			System.out.println("Obrero " + nombre + " poniendo ladrillos en el metro " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(i % 10 == 0) {
				if(!silla.getOcupada())
					silla.ocuparSilla(this);
			}
		}
	}

	@Override
	public void run() {
		contruirValla();		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
