package modelo.entidades;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Videojuego {
	private int id;
	private String nombre;
	private String company;
	private int valoracion;
	private double precio;
	
	public Videojuego() {}
	
	public Videojuego(String nombre, String company, int valoracion, double precio) {
		this.nombre = nombre;
		this.company = company;
		this.valoracion = valoracion;
		this.precio = precio;
	}
	
	public Videojuego(String nombre, String company) {
		this.nombre = nombre;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		String precio = Double.toString(this.getPrecio());
		String valoracion = Integer.toString(this.getValoracion());
		
		if(this.getPrecio() == -1) {
			precio = "PREPARANDO";
		}
		
		if(this.getValoracion() == -1) {
			valoracion = "PREPARANDO";
		}
		
		return "(id=" + id + ", nombre=" + nombre + ", compañía=" + company + ", valoracion=" + valoracion
				+ ", precio=" + precio + ")";			

	}
}
