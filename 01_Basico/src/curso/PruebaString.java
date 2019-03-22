package curso;

public class PruebaString {

	public static void main(String[] args) {
		String s1 = new String("Mario");
		String s2 = "Mario";
		
		String s3 = "Mario";
		
		if(s2 == s3) {
			System.out.println("Las dos referencias están apuntando al mismo objeto");
		}
		
		if(s1 == s3) {
			System.out.println("Son iguales 2");
		}

		if(s1.equals(s2)) {
			System.out.println("Si tienen el mismo estado");
		}
		
		if(s1.equalsIgnoreCase("MARIO")) {
			System.out.println("Ignorando mayus and minus");
		}
		
		String s4 = s2.toLowerCase();
		System.out.println(s2);
		System.out.println(s4);
		
		String s5 = s2.toUpperCase();
		System.out.println(s2);
		System.out.println(s5);
		
		String s6 = "Esto es una cadena";
		String[] arrStrings = s6.split(" ");
		for(String s : arrStrings) {
			System.out.println(s);
		}
		
		// Operar con strings como si fueran números
		String s7 = "10";
		String s8 = "20";
		System.out.println(s7 + s8);
		
		int i1 = Integer.parseInt(s7);
		int i2 = Integer.parseInt(s8);
		
		System.out.println(i1 + i2);
		
		String s9 = "23.45";
		double d1 = Double.parseDouble(s9);
	}

}
