package spring6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main6 {
	private static ApplicationContext context = null;
	
	static {
		context = new ClassPathXmlApplicationContext("beans6.xml");
	}

	public static void main(String[] args) {
		Persona p = context.getBean("persona", Persona.class);
		System.out.println(p);
	}
}
