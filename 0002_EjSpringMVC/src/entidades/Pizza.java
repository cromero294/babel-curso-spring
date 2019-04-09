package entidades;

public class Pizza {
	private String[] ingredientes;
	private String tam;

	public String[] getIngredientes() {
		return ingredientes;
	}
	
	public String getIngredientesString() {
		return ingredientes.toString();
	}

	public void setIngredientes(String[] ingredientes2) {
		this.ingredientes = ingredientes2;
	}

	public String getTam() {
		return tam;
	}

	public void setTam(String tam) {
		this.tam = tam;
	}

	@Override
	public String toString() {
		return "Pizza [ingredientes=" + ingredientes.toString() + ", tam=" + tam + "]";
	}
}
