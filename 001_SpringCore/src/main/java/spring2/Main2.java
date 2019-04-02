package spring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
	private static ApplicationContext context = null;
	
	static {
		context = new ClassPathXmlApplicationContext("beans2.xml");
	}

	public static void main(String[] args) {
		Imprimir imprimir = context.getBean("imprimible", Imprimir.class);
		imprimir.imprimir("Hola mundo!");
	}

}
