package entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// List es la interfaz de la clase lista y es una coleccion
		// de métodos.
		System.out.println("----------------- Listas ------------------");
		
		List<String> listaString = new ArrayList<String>();
		listaString.add("Ana");
		listaString.add("Juana");
		listaString.add("Pepe");
		listaString.add("Juana");
		
		for(String s : listaString) {
			System.out.println(s);
		}
		
		System.out.println(listaString.get(0)); // Ana
		listaString.remove("Ana");
		listaString.remove("Juana");
		
		System.out.println(listaString);
		System.out.println(listaString.size());
		
		System.out.println("----------------- Conjuntos ------------------");
		
		// PAra saber si un objeto es igual a otro se utiliza equals
		Set<String> conjunto = new HashSet<String>();
		conjunto.add("Ana");
		conjunto.add("Juana");
		conjunto.add("Pepe");
		conjunto.add("Juana");
		
		System.out.println(conjunto);
		
		System.out.println("----------------- Maps ------------------");
		
		// tipos wrapper (envoltorio) son los tipos objeto de los primitivos
		// todos los primitivos tienen su tipo wrapper que suele llamarse igual pero con UpperCase la primera
		// int -> Integer
		// double -> Double
		// Double num = new Double(2.3);
		
		// Auto-boxing, que es pasar directamente de primitivo a objeto
		// Double d2 = 2.3;
		
		// Auto-unboxing
		// double d3 = new Double(2.3);
		
		Map<Integer,String> map = new HashMap<>();
		
		map.put(0, "Mario");
		map.put(1, "Raquel");
		
		String s = map.get(0);
		
		System.out.println(s);
		
		s = map.get(4);
		
		System.out.println(s);
		
		// No pueden existir claves duplicadas por lo que si se repite se sobreescribe el valor.
	}

}
