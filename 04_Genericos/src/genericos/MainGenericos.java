package genericos;

public class MainGenericos {

	public static void main(String[] args) {
		AlmacenString as = new AlmacenString();
		as.setValor("Este sería un string");
		System.out.println(as.getValor());
		
		AlmacenEnteros as1 = new AlmacenEnteros();
		as1.setValor(5);
		System.out.println(as1.getValor());
		
		AlmacenObjects as2 = new AlmacenObjects();
		as2.setValor(18);
		Integer val = (Integer)as2.getValor();
		System.out.println(val);
		
		// 1.5 de java nacen los genericos
		
		Almacen<String> almacen = new Almacen<>();
		almacen.setValor("Esto es, ni más ni menos, que otro string");
		String s = almacen.getValor();
		System.out.println(s);
	}

}
