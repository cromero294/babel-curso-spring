package spring0;

public class FabricaImprimibles {
	public static Imprimir crear(String tipo) {
		switch(tipo) {
			case "fichero":
				ImprimirPorFichero ipf = new ImprimirPorFichero();
				return ipf;
			case "pantalla":
				ImprimirPorPantalla ipp = new ImprimirPorPantalla();
				return ipp;
			default:
				return null;	
		}
	}
}
