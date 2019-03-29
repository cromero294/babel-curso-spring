package modelo.negocio;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import modelo.entidades.Videojuego;
import persistencia.DaoVideojuego;

public class GestorVideojuegos implements Runnable{
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
		
		System.out.println(nombre);
		
		if(nombre.equals("\n") || company.equals("\n") || nombre.equals("") || company.equals("")) {
			return false;
		}
		
		videojuego.setNombre(nombre);
		videojuego.setCompany(company);
		videojuego.setValoracion(valoracion);
		videojuego.setPrecio(precio);			
		
		return DaoVideojuego.getInstance().crear(videojuego);
	}
	
	public boolean eliminar(String nombre) {
		return DaoVideojuego.getInstance().eliminar(nombre);
	}
	
	public boolean modificar(String nombre, String company, int valoracion, double precio, int id) {
		Videojuego videojuego = new Videojuego();
		
		if(nombre.equals("\n") || company.equals("\n") || nombre.equals("") || company.equals("")) {
			return false;
		}
		
		videojuego.setNombre(nombre);
		videojuego.setCompany(company);
		videojuego.setValoracion(valoracion);			
		videojuego.setPrecio(precio);			
		
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
	
	public Map<String, Integer> listar() {
		return DaoVideojuego.getInstance().listar();
	}
	
	public double valoracionMedia() {
		return DaoVideojuego.getInstance().valoracionMedia();
	}
	public double precioMedia() {
		return DaoVideojuego.getInstance().precioMedia();
	}
	
	@Override
	public void run() {
		try (FileWriter fw = new FileWriter("ficheroBackup.txt");
				PrintWriter pw = new PrintWriter(fw)) {
			for(Videojuego v : DaoVideojuego.getInstance().listarBackup()) {
				pw.println(v.toString());
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}	
	}
}
