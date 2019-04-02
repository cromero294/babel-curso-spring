package spring3;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main3 {
	private static ApplicationContext context = null;
	
	static {
		context = new ClassPathXmlApplicationContext("beans3.xml");
	}

	public static void main(String[] args) {
		// Al ser Prototype cada vez que pida una persona será nueva y
		// el ciclo de vida depende de nosotros y no de spring.
		Persona p1 = context.getBean("personaBean", Persona.class);
		Persona p2 = context.getBean("personaBean", Persona.class);
		Persona p3 = context.getBean("personaBean", Persona.class);
		
		List<Persona> listPersonas = context.getBean("listaPersonas", List.class);
		
		listPersonas.add(p1);
		listPersonas.add(p2);
		listPersonas.add(p3);
		
		Persona carlos = context.getBean("carlos", Persona.class);
		System.out.println(carlos);
	}
}
