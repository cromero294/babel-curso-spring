package es.babel.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.babel.modelo.entidades.GrupoOperaciones;
import es.babel.modelo.entidades.Operacion;

@Repository
public interface OperacionDAO extends JpaRepository<Operacion, Integer>{
	public Operacion findByOp1AndOp2AndOperacion(Integer op1, Integer op2, String operacion);
	public List<Operacion> findByOperacion(String operacion);
}
