package curso;

public class Funciones {

	public static void main(String[] args) {
		saludar();
		saludar("Hola Pepe.");
		int numero = sumar(1,3);
		System.out.println(numero);
	}

	// La firma de un método en java consta de
	// 	1 - Nombre del método
	// 	2 - Número de los parámetros de entrada
	//  3 - Tipo de los parámetros de entrada
	
	public static void saludar() {
		System.out.println("Hola mundo!");
	}
	
	public static void saludar(String saludo) {
		System.out.println(saludo);
	}
	
	public static int sumar(int n1, int n2) {
		return n1+n2;
	}
	
	public static double sumar(double n1, double n2) {
		return n1+n2;
	}
	
	// Mismo nombre de la función y distintos argumentos
	// se le llama sobrecargar una función.
	public static int sumar(int n1, int n2, int n3) {
		return n1+n2+n3;
	}
	
	public static int sumar(int... numeros) {
		int resultado = 0;
		
		for(int numero : numeros) {
			resultado += numero;
		}
		
		return resultado;
	}
}
