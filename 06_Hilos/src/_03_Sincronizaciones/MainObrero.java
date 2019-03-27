package _03_Sincronizaciones;

public class MainObrero {

	public static void main(String[] args) {
		Silla silla = new Silla();
		
		Obrero o1 = new Obrero("Currito", 1, 100, silla);
		Obrero o2 = new Obrero("MalaSombra", 101, 200, silla);
		Obrero o3 = new Obrero("Currómetro", 201, 300, silla);
		Obrero o4 = new Obrero("CurroPorDinero", 301, 400, silla);
		Obrero o5 = new Obrero("SiNoCurroMeMuero", 401, 500, silla);
		
		new Thread(o1).start();
		new Thread(o2).start();
		new Thread(o3).start();
		new Thread(o4).start();
		new Thread(o5).start();
		
	}

}
