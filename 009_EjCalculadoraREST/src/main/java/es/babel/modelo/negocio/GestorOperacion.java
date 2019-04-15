package es.babel.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.babel.modelo.entidades.GrupoOperaciones;
import es.babel.modelo.entidades.Operacion;
import es.babel.modelo.persistencia.OperacionDAO;

@Service
public class GestorOperacion {
	@Autowired
	OperacionDAO operacionDao;
	
	@Transactional
	public Operacion insertar(Operacion p) {
		return operacionDao.save(p);
	}
	
	@Transactional
	public Operacion modificar(Operacion p) {
		return operacionDao.save(p);
	}
	
	@Transactional
	public void borrar(int id) {
		operacionDao.deleteById(id);
	}
	
	public Operacion buscar(int op1, int op2, String tipo) {
		return operacionDao.findByOp1AndOp2AndOperacion(op1, op2, tipo);
	}
	
	public List<Operacion> listar() {
		return operacionDao.findAll();
	}
	
	public double calcular(int op1, int op2, String tipo) {
		double resultado = 0.0;
		
		switch(tipo) {
			case "suma":
				resultado = op1 + op2;
				break;
			case "resta":
				resultado = op1 - op2;
				break;
			case "multiplicacion":
				resultado = op1 * op2;
				break;
			case "division":
				resultado = op1 / op2;
				break;
		}
		
		return resultado;
	}

	public List<Operacion> buscarOperacion(String tipo) {
		return operacionDao.findByOperacion(tipo);
	}
}
