package genericos;

// Parametrizamos la clase, es decir, que el programador pueda elegir
// el tipo de datos que quiere utilizar cuando se crea el objeto.
public class Almacen<T extends Object> {
	private T valor;

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return (String)this.valor;
	}
}
