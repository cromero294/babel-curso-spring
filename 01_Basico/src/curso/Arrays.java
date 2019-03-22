package curso;

public class Arrays {

	public static void main(String[] args) {
		// Los arrays son una colección ordenada de elementos de un mismo tipo
		// Los arrays "normales" son estáticos, es decir, se crean con
		// un número de elementos y no se puede modificar.
		
		int[] enteros = new int[5];
		int[] enteros2 = {1,2,3,4,5,6,7,8,9};
		
		enteros[0] = 1;
		enteros[1] = 2;
		
		//enteros[9] = 7;
		System.out.println(enteros[0]);
		for(int i : enteros) {
			System.out.println(i);
		}
		
	}

}
