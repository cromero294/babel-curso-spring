package es.babel.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.babel.modelo.entidades.GrupoOperaciones;
import es.babel.modelo.entidades.Operacion;
import es.babel.modelo.negocio.GestorOperacion;

@RestController()
public class ControladorOperacion {
	@Autowired
	GestorOperacion go;
	
	@GetMapping(path="{op1}/{op2}/{tipo}",produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Operacion> obtenerOperacion(
			@PathVariable("op1") int op1,
			@PathVariable("op2") int op2,
			@PathVariable("tipo") String tipo){
		
		if(!tipo.equals("suma") && !tipo.equals("resta") && !tipo.equals("multiplicacion") && !tipo.equals("division")) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}
		
		Operacion p = go.buscar(op1, op2, tipo);		
		
		if(p == null) {
			p = new Operacion();
			p.setOp1(op1);
			p.setOp2(op2);
			p.setOperacion(tipo);
			double resultado = go.calcular(op1, op2, tipo);
			p.setResultado(resultado);
			
			go.insertar(p);
		}
		
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@GetMapping(path="{tipo}",produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<GrupoOperaciones> obtenerOperacion(@PathVariable("tipo") String tipo){
		
		if(!tipo.equals("suma") && !tipo.equals("resta") && !tipo.equals("multiplicacion") && !tipo.equals("division")) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}
		
		List<Operacion> lo = go.buscarOperacion(tipo);
		GrupoOperaciones p = new GrupoOperaciones();
		p.setListaOperaciones(lo);
		
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@GetMapping(path="",produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<GrupoOperaciones> obtenerOperacion(){
		
		List<Operacion> lo = go.listar();
		GrupoOperaciones p = new GrupoOperaciones();
		p.setListaOperaciones(lo);
		
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
}
