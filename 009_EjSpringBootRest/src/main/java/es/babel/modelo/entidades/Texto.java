package es.babel.modelo.entidades;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Texto {
	private String nombre;
	private String mensaje;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	@Override
	public String toString() {
		return "Texto [nombre=" + nombre + ", texto=" + mensaje + "]";
	}
}
