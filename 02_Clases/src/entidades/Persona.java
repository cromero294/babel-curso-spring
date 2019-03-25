package entidades;

// Las clases son moldes para crear objetos. Tienen atributos y métodos
public class Persona {
	private static int numeroPersonas;
	
	// Las referencias se inicializan a null y los primitivos a null por defecto
	private String nombre;
	private double altura;
	private int edad;
	private Direccion direccion;
	
	public Persona() {
		super();
		Persona.numeroPersonas++;
	}
	
	public Persona(String nombre, double altura, int edad) {
		this();
		// this se puede definir como una referencia al propio objeto
		this.altura = altura;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public static int getNumeroPersonas() {
		return Persona.numeroPersonas;
	}
	
	public static void setNumeroPersonas(int num) {
		Persona.numeroPersonas = num;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", altura=" + altura + ", edad=" + edad + ", direccion=" + direccion + "]";
	}

}
