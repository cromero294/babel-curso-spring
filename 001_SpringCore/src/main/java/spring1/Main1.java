package spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		
		// Objeto no gestionado por el contexto de spring
		Mensaje mensajeNoGestionado = new Mensaje();
		
		// Accedemos a sus propiedades.
		Mensaje mensaje1 = context.getBean("mensaje1", Mensaje.class);
		mensaje1.setId(123);
		mensaje1.setCuerpo("Cuerpo nuevo.");
		mensaje1.setFirma("Laura");
		
		Mensaje mensaje2 = context.getBean("mensaje2", Mensaje.class);
		System.out.println(mensaje2);
		mensaje2.setFirma("Otra persona");
		
		// No hace falta volver a pedirlo al bean
		mensaje2 = context.getBean("mensaje2", Mensaje.class);
		System.out.println(mensaje2);
		
		funcion(context);
	}

	private static void funcion(ApplicationContext context) {
		Mensaje m1 = context.getBean("mensaje1", Mensaje.class);
		System.out.println(m1);
	}

}
