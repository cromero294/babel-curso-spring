package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.Configuracion;
import vista.EntradaSalida;

public class Main {

	private static ApplicationContext context = null;
	
	static {
		context = new AnnotationConfigApplicationContext(Configuracion.class);
	}
	
	public static void main(String[] args) {
		EntradaSalida io = context.getBean("entradaSalida", EntradaSalida.class);
		
		io.menu();
	}

}
