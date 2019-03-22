package ejercicio01;

public class Main {

	public static void main(String[] args) {
		Direccion d = new Direccion("AV", "Navarrondán", "28702", "España");
		
		Persona p1 = new Persona("Mario", 1.78, 21, d);
		Persona p2 = new Persona("Juan", 1.80, 48, d);
		Persona p3 = new Persona("Pepa", 1.90, 49, d);
		
		Persona[] inquilinos =  {p2, p3};
		
		Habitacion h1 = new Habitacion(23.4, "baño");
		Habitacion h2 = new Habitacion(2.4, "cocina");
		Habitacion h3 = new Habitacion(293.4, "salon");
		
		Habitacion[] habitaciones = {h1, h2, h3};
		
		Casa c1 = new Casa(900, d, p1, false, habitaciones, inquilinos);
		
		System.out.println(c1);
	}

}
