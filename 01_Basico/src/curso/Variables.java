package curso;

public class Variables {
	public static void main(String[] args) {
		// Java es un lenguaje fuertemente tipado,
		// diferenciamos entre primitivos y referencias.
		
		// Variables primitivas guardan el valor del dato.
		// Referencias guardan la posición de memoria.
		
		int numero1 = 34;
		byte numero2 = 127;
		double numero3 = 23.45;
		float numero4 = 23.56F; // No se suelen utilizar
		boolean bool = true;
		
		// Desde la 1.7
		int numero5 = 10_000_000;
		int num1 = 10;
		int num2 = 3;
		double num3 = (double) num1 / num2;
		System.out.println(num3);
		
		long largo = 100000000000000000L;
		
		int numeroHexadecimal = 0xAAF45;
		int numeroOctal = 0567;
		int numeroBinario = 0b1000010;
		System.out.println(numeroHexadecimal);
		System.out.println(numeroOctal);
		System.out.println(numeroBinario);
	}
}
