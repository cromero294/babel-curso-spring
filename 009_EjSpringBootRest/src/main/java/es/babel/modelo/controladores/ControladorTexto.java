package es.babel.modelo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.babel.modelo.gestores.GestorTexto;

import es.babel.modelo.entidades.Texto;

@RestController()
public class ControladorTexto {
	@Autowired
	GestorTexto gt;
	//http://localhost:8080/14_REST/mvc/historia
	@GetMapping(path="historia",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Texto> texto(){
		System.out.println("Entrando...");
		return new ResponseEntity<>(gt.pedir(),HttpStatus.OK);
	}
}
