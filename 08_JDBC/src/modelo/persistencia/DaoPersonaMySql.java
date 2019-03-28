package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Persona;

public class DaoPersonaMySql implements DaoPersona{

	private Connection conexion;
	
	// Cargar la clase de mySQL que nos permita realizar las conexiones a la base de datos.
	// Los bloques estaticos sirven para ejecutar un código nada más arrancar el programa
	// en la máquina virtual.
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver cargado.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private boolean abrirConexion() {
		String url = "jdbc:mysql://localhost:3306/prueba?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
	public boolean alta(Persona p) {
		if(!abrirConexion()) {
			return false;
		}
		
		boolean alta = true;
		String query = "insert into personas (NOMBRE, EDAD, PESO) values (?,?,?)";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getEdad());
			ps.setDouble(3, p.getPeso());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return alta;
	}

	@Override
	public boolean eliminar(int id) {
		if(!abrirConexion()) {
			return false;
		}
		
		boolean alta = true;
		String query = "delete from personas where id=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return alta;
	}

	@Override
	public boolean update(Persona p) {
		if(!abrirConexion()) {
			return false;
		}
		
		boolean alta = true;
		String query = "update personas set NOMBRE=?,EDAD=?,PESO=? where id=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getEdad());
			ps.setDouble(3, p.getPeso());
			ps.setInt(4, p.getId());
			
			int numeroColumnasAfectadas = ps.executeUpdate();
			if(numeroColumnasAfectadas == 0) {
				alta = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return alta;
	}

	@Override
	public Persona obtener(int id) {
		if(!abrirConexion()) {
			return null;
		}
		
		Persona persona = null;
		String query = "select * from personas where id=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				persona = new Persona();
				persona.setId(rs.getInt(1));
				persona.setNombre(rs.getString(2));
				persona.setEdad(rs.getInt(3));
				persona.setPeso(rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return persona;
	}

	@Override
	public List<Persona> listar() {
		if(!abrirConexion()) {
			return null;
		}
		
		List<Persona> personas = new ArrayList<Persona>();
		Persona persona = null;
		String query = "select * from personas";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				persona = new Persona();
				persona.setId(rs.getInt(1));
				persona.setNombre(rs.getString(2));
				persona.setEdad(rs.getInt(3));
				persona.setPeso(rs.getDouble(4));
				
				personas.add(persona);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cerrarConexion();
		}
		
		return personas;
	}

}
