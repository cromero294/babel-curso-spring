package es.babel.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope("prototype")
@Table(name="operaciones")
@XmlRootElement
public class Operacion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int op1;
	private int op2;
	private String operacion;
	private double resultado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOp1() {
		return op1;
	}
	public void setOp1(int op1) {
		this.op1 = op1;
	}
	public int getOp2() {
		return op2;
	}
	public void setOp2(int op2) {
		this.op2 = op2;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	
	@Override
	public String toString() {
		return "Operacion [id=" + id + ", op1=" + op1 + ", op2=" + op2 + ", operacion=" + operacion + ", resultado="
				+ resultado + "]";
	}
}
