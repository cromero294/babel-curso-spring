package curso;

public class SentenciasControl {

	public static void main(String[] args) {
		boolean esCierto = true;
		if(esCierto) {
			System.out.println("Es cierto");
		}
		
		if(!esCierto) {
			System.out.println("Aquí no entramos");
		}
		
		boolean otraEsCierto = true;
		if(esCierto || otraEsCierto) {
			// Comparación or
		}
		
		if(esCierto && otraEsCierto) {
			// Comparación and
		}else {
			// Sentencia else
		}
		
		if(esCierto) {
			// Sentencia if
		}else if(otraEsCierto){
			// Sentencia else if
		}else {
			// Sentencia else
		}
		
		// Primitivos, Strings(desde la 7), Enumerados
		String diaDeLaSemana = "Viernes";
		
		switch (diaDeLaSemana) {
		case "Lunes":
		case "Martes":
		case "Miercoles":
		case "Jueves":
		case "Viernes":
			System.out.println("Entre semana.");
			break;
		case "Sabado":
		case "Domingo":
			System.out.println("Fin de semana.");
			break;
		default:
			break;
		}
		
		for(int i = 0; i < 10; i++) {
			// Codigo a ejecutar
		}
		
		while(!esCierto) { // 0-N veces
			// Hmmm
		}
		
		do { // Se ejecuta entre 1 .. N
			
		}while(!esCierto);
		
		String cadena = esCierto ? "Es cierto" : "No es cierto";
	}

}
