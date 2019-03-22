package curso;

import java.util.Scanner;

public class EntradaSalida {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// System.in
		// System.out
		// System.err
		
		System.out.println("Por favor, introduzca un número: ");
		int numero = sc.nextInt();
		System.out.println(numero);
	}

}
