package spring0;

public class MainFabrica {

	public static void main(String[] args) {
		String modo = args[0];
		
		Imprimir imp = FabricaImprimibles.crear(modo);
		imp.imprimir("Hola mundo!");
		
//		if(modo.equals("1")) {
//			// En modo fichero
//			Imprimir ipm = FabricaImprimibles.crear("fichero");
//			ipm.imprimir("Hola mundo!");
//		}else {
//			Imprimir ipp = FabricaImprimibles.crear("pantalla");
//			ipp.imprimir("Hola mundo!");
//		}
	}

}
