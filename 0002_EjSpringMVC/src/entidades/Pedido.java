package entidades;

import java.util.List;

public class Pedido {
	private String usuario;
	private String direccion;
	private List<Pizza> listaPizzas;
	
	public List<Pizza> getListaPizzas() {
		return listaPizzas;
	}
	public void setListaPizzas(List<Pizza> listaPizzas) {
		this.listaPizzas = listaPizzas;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Pedido [usuario=" + usuario + ", listaPizzas=" + listaPizzas + "]";
	}
}
