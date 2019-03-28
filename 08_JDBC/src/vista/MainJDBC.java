package vista;

import modelo.entidades.Persona;
import modelo.negocio.GestorPersona;

public class MainJDBC {

	public static void main(String[] args) {
		GestorPersona gp = new GestorPersona();
		Persona p = new Persona();
		p.setNombre("Mario");
		p.setEdad(22);
		p.setPeso(69.5);
		
		gp.alta(p);
		
		p.setId(1);
		p.setNombre("Radu");
		
		gp.update(p);
		
		System.out.println(gp.obtener(1));
		
		p.setNombre("Mario");
		p.setEdad(21);
		p.setPeso(70.8);
		
		gp.alta(p);
		
		for(Persona pers : gp.listar()) {
			System.out.println(pers);
		}
	}

}
