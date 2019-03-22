package entidades;

public class Main {

	public static void main(String[] args) {
		Persona p1 = new Persona();
		crearObjeto();
		
		p1.setNombre("Ana");
		p1.setAltura(1.76);
		p1.setEdad(33);
		
		Persona p2 = new Persona();
		p2.setNombre("Pepe");
		p2.setAltura(1.80);
		p2.setEdad(44);
		
		p1 = p2;
		p2.setEdad(55);
		
		modificarEdad(p2);
		System.out.println(p1.getEdad());
		
		int i = 5;
		modificarEntero(i);
		System.out.println(i);
		
		Persona p3 = new Persona("Roberto", 1.55, 23);
		System.out.println(p3); // Invoca automaticamente al toString()
		
		Direccion d1 = new Direccion();
		d1.setNombreVia("Gran via");
		d1.setTipoVia("Calle");
		d1.setCp("28223");
		d1.setPais("España");
		
		p3.setDireccion(d1);
		System.out.println(p3);
		d1.setPais("Francia");
		System.out.println(p3);
	}
	
	public static void modificarEntero(int i) {
		i = 10;
	}
	
	public static void modificarEdad(Persona p) {
		p.setEdad(77);
	}
	
	public static void crearObjeto() {
		Persona p2 = new Persona();
	}

}
