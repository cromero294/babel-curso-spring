package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vista.EntradaSalida;

public class Main {

	private static ApplicationContext context = null;
	
	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	public static void main(String[] args) {
		EntradaSalida io = context.getBean("entradaSalida", EntradaSalida.class);
		
		io.menu();
	}

}
