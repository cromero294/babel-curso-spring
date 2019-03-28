package negocio;

public class MainSingleton {

	public static void main(String[] args) {
		ObjetoSingleton os = ObjetoSingleton.getInstance();
		os.setNombre("Mario");
		
		unaFuncion();
	}

	private static void unaFuncion() {
		otraFuncion();
	}

	private static void otraFuncion() {
		yOtraMas();
	}

	private static void yOtraMas() {
		// Si aquí quiero imprimir el nombre del opbjeto singleton tendría que pasarlo por parametro
		// pero con singleton vale con hacer:
		System.out.println(ObjetoSingleton.getInstance().getNombre());
	}

}
