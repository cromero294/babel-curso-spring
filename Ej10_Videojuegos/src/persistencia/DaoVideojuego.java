package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Videojuego;

public class DaoVideojuego implements IDaoVideojuegos{

	private static DaoVideojuego instancia = null;
	private Connection conexion;
	
	private DaoVideojuego() {
		super();
	}
	
	public static DaoVideojuego getInstance() {
		if(instancia == null) {
			instancia = new DaoVideojuego();
		}
		
		return instancia;
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver cargado.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private boolean abrirConexion() {
		String url = "jdbc:mysql://localhost:3306/videojuegos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pass = "password";
		
		try {
			conexion = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private boolean cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean crear(Videojuego v) {
		if(!abrirConexion()) {
			return false;
		}
		
		String query = "insert into videojuegos (NOMBRE, COMPANY, VALORACION, PRECIO) values (?,?,?,?)";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, v.getNombre());
			ps.setString(2, v.getCompany());
			ps.setInt(3, v.getValoracion());
			ps.setDouble(4, v.getPrecio());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return true;
	}

	@Override
	public boolean eliminar(String nombre) {
		if(!abrirConexion()) {
			return false;
		}
		
		String query = "delete from videojuegos where nombre=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, nombre);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return true;
	}

	@Override
	public boolean modificar(Videojuego v, int id) {
		if(!abrirConexion()) {
			return false;
		}
		
		String query = "update from videojuegos set NOMBRE=?,COMPANY=?,VALORACION=?,PRECIO=? where id=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, v.getNombre());
			ps.setString(2, v.getCompany());
			ps.setInt(3, v.getValoracion());
			ps.setDouble(4, v.getPrecio());
			ps.setInt(5, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return true;
	}

	@Override
	public Videojuego buscar(String nombre) {
		if(!abrirConexion()) {
			return null;
		}
		
		Videojuego videojuego = null;
		String query = "select * from videojuegos where nombre=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, nombre);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				videojuego = new Videojuego(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
				videojuego.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return videojuego;
	}

	@Override
	public Videojuego buscar(int id) {
		if(!abrirConexion()) {
			return null;
		}
		
		Videojuego videojuego = null;
		String query = "select * from videojuegos where id=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				videojuego = new Videojuego(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
				videojuego.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return videojuego;
	}

	@Override
	public boolean eliminar(int id) {
		if(!abrirConexion()) {
			return false;
		}
		
		String query = "delete from videojuegos where id=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return true;
	}

	@Override
	public List<Videojuego> listar() {
		if(!abrirConexion()) {
			return null;
		}
		
		List<Videojuego> listaVideojuegos = new ArrayList<Videojuego>();
		Videojuego videojuego = null;
		String query = "select * from videojuegos";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				videojuego = new Videojuego(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
				videojuego.setId(rs.getInt(1));
				
				listaVideojuegos.add(videojuego);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return listaVideojuegos;
	}

	@Override
	public double valoracionMedia() {
		if(!abrirConexion()) {
			return -1;
		}
		
		String query = "select avg(valoracion) from videojuegos";
		double valor = 0;
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				valor = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return valor;
	}

	@Override
	public double precioMedia() {
		if(!abrirConexion()) {
			return -1;
		}
		
		String query = "select avg(precio) from videojuegos";
		double valor = 0;
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				valor = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return valor;
	}

}
