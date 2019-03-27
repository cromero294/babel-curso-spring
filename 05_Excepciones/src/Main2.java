import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main2 {
	public static void main(String[] args) {
		CuentaBancaria cb = new CuentaBancaria(400);
		
		try {
			cb.sacarDinero(600);
		} catch (SaldoInsuficienteException e) {
			e.printStackTrace();
		}
		
		
		// Try autocloseable. Se cierran las cosas automaticamente
		try (FileWriter fw = new FileWriter("fichero2.txt");
				PrintWriter pw = new PrintWriter(fw)) {
			pw.println("Esto es una prueba.");
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
