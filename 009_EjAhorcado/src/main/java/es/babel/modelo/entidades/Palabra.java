package es.babel.modelo.entidades;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope("prototype")
@Table(name="palabras")
@XmlRootElement
public class Palabra {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String palabra;
	private int size;
	
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Palabra [id=" + id + ", palabra=" + palabra + ", size=" + size + "]";
	}
}
