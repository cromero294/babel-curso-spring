package es.babel.modelo.gestores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.babel.modelo.entidades.Texto;
import es.babel.modelo.persistencia.TextoDAO;

@Service
public class GestorTexto {
	
	@Autowired
	private TextoDAO textodao;
	
	public Texto pedir(){
		System.out.println("gestor");
		
		Texto texto = textodao.consumir();
		
		texto.setMensaje(texto.getMensaje() + " Igual a " + texto.getNombre() + " le gustaban más otro tipo de libros.");
		
		return texto;		
	}
}
