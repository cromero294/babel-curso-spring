package negocio;

// Lo que busca es que haya una única instancia de un objeto en todo el programa.
// El objetivo de este patrón es evitar el gasto de procesamiento y de memoria
// que puede tener el crear todos los objetos que tú quieras.

// Por otro lado se busca tener acceso al objeto desde cualquier parte de la aplicación.
public class ObjetoSingleton {
	// Carga ansiosa es que el objeto existe siempre mientras que la perezosa es bajo demanda
	// private static ObjetoSingleton instancia = new ObjetoSingleton();
	
	private static ObjetoSingleton instancia = null;
	private String nombre;
	
	private ObjetoSingleton() {
		super();
	}
	
	public static ObjetoSingleton getInstance() {
		if(instancia == null) {
			instancia = new ObjetoSingleton(); // Carga perezosa, es decir, no se crea el objeto hasta que se necesita.
		}
		
		return instancia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
