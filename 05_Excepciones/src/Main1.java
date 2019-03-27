import java.util.InputMismatchException;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduzca dos números: ");
			int dividendo = sc.nextInt();
			int divisor = sc.nextInt();
			
			int resultado = dividendo / divisor;
			System.out.println(resultado);			
		}catch(InputMismatchException e) {
			System.out.println("Ha introducido un valor no válido.");
		}catch(ArithmeticException e) {
			System.out.println("Ha introducido un 0.");
		}catch(Exception e) {
			System.out.println("Erroraco.");
		}finally {
			// Se ejecuta siempre y suele servir para cerrar algun tipo de recurso
		}
	}

}
