package persistencia;

import java.util.List;

import modelo.entidades.Videojuego;

public interface IDaoVideojuegos {
	public boolean crear(Videojuego v);
	public boolean eliminar(String nombre);
	public boolean modificar(Videojuego v, int id);
	public Videojuego buscar(String nombre);
	public Videojuego buscar(int id);
	public boolean eliminar(int id);
	public List<Videojuego> listar();
	public double valoracionMedia();
	public double precioMedia();
}
