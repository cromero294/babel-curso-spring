package modelo.negocio;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.entidades.Videojuego;
import persistencia.DaoVideojuego;

public class GestorVideojuegos implements Runnable{
	
	private DaoVideojuego daoVideojuego;
	private Videojuego videojuego;
	
	public DaoVideojuego getDaoVideojuego() {
		return daoVideojuego;
	}

	public void setDaoVideojuego(DaoVideojuego daoVideojuego) {
		this.daoVideojuego = daoVideojuego;
	}

	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

	public boolean crear(String nombre, String company, int valoracion, double precio) {
		if(nombre.equals("\n") || company.equals("\n") || nombre.equals("") || company.equals("")) {
			return false;
		}
		
		videojuego.setNombre(nombre);
		videojuego.setCompany(company);
		videojuego.setValoracion(valoracion);
		videojuego.setPrecio(precio);			
		
		return daoVideojuego.crear(videojuego);
	}
	
	public boolean eliminar(String nombre) {
		return daoVideojuego.eliminar(nombre);
	}
	
	public boolean modificar(String nombre, String company, int valoracion, double precio, int id) {
		if(nombre.equals("\n") || company.equals("\n") || nombre.equals("") || company.equals("")) {
			return false;
		}
		
		videojuego.setNombre(nombre);
		videojuego.setCompany(company);
		videojuego.setValoracion(valoracion);			
		videojuego.setPrecio(precio);			
		
		return daoVideojuego.modificar(videojuego, id);
	}
	
	public Videojuego buscar(String nombre) {
		return daoVideojuego.buscar(nombre);
	}
	
	public Videojuego buscar(int id) {
		return daoVideojuego.buscar(id);
	}
	
	public boolean eliminar(int id) {
		return daoVideojuego.eliminar(id);
	}
	
	public Map<String, Integer> listar() {
		return daoVideojuego.listar();
	}
	
	public double valoracionMedia() {
		return daoVideojuego.valoracionMedia();
	}
	public double precioMedia() {
		return daoVideojuego.precioMedia();
	}
	
	@Override
	public void run() {
		try (FileWriter fw = new FileWriter("ficheroBackup.txt");
				PrintWriter pw = new PrintWriter(fw)) {
			for(Videojuego v : daoVideojuego.listarBackup()) {
				pw.println(v.toString());
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}	
	}
}
