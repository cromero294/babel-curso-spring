package modelo.negocio;

import java.util.List;

import modelo.entidades.Videojuego;
import persistencia.DaoVideojuego;

public class GestorVideojuegos {
	private static GestorVideojuegos instancia = null;
	
	private GestorVideojuegos() {
		super();
	}
	
	public static GestorVideojuegos getInstance() {
		if(instancia == null) {
			instancia = new GestorVideojuegos();
		}
		
		return instancia;
	}
	
	public boolean crear(String nombre, String company, int valoracion, double precio) {
		Videojuego videojuego = new Videojuego();
		
		if(nombre == "\n" || company == "\n" || nombre == "" || company == "") {
			return false;
		}
		
		videojuego.setNombre(nombre);
		videojuego.setCompany(company);
		
		if(valoracion >= 0 && valoracion <= 10) {
			videojuego.setValoracion(valoracion);			
		}
		
		if(precio >= 0) {
			videojuego.setPrecio(precio);			
		}
		
		return DaoVideojuego.getInstance().crear(videojuego);
	}
	
	public boolean eliminar(String nombre) {
		return DaoVideojuego.getInstance().eliminar(nombre);
	}
	
	public boolean modificar(String nombre, String company, int valoracion, double precio, int id) {
		Videojuego videojuego = new Videojuego();
		
		if(nombre == "\n" || company == "\n" || nombre == "" || company == "") {
			return false;
		}
		
		videojuego.setNombre(nombre);
		videojuego.setCompany(company);
		
		if(valoracion >= 0 && valoracion <= 10) {
			videojuego.setValoracion(valoracion);			
		}
		
		if(precio >= 0) {
			videojuego.setPrecio(precio);			
		}
		
		return DaoVideojuego.getInstance().modificar(videojuego, id);
	}
	
	public Videojuego buscar(String nombre) {
		return DaoVideojuego.getInstance().buscar(nombre);
	}
	
	public Videojuego buscar(int id) {
		return DaoVideojuego.getInstance().buscar(id);
	}
	
	public boolean eliminar(int id) {
		return DaoVideojuego.getInstance().eliminar(id);
	}
	
	public List<Videojuego> listar() {
		return DaoVideojuego.getInstance().listar();
	}
	
	public double valoracionMedia() {
		return DaoVideojuego.getInstance().valoracionMedia();
	}
	public double precioMedia() {
		return DaoVideojuego.getInstance().precioMedia();
	}
}
