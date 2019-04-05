package modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import modelo.entidades.Pelicula;

// Simplifica la conversion de un ResultSet a objetos
@Component
public class PeliculaDaoRowMapper implements RowMapper<Pelicula> {

	@Override
	public Pelicula mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pelicula p = new Pelicula();
		
		p.setId(rs.getInt("ID"));
		p.setTitulo(rs.getString("TITULO"));
		p.setDirector(rs.getString("DIRECTOR"));
		p.setGenero(rs.getString("GENERO"));
		p.setYear(rs.getInt("YEAR"));
		
		return p;
	}

}
