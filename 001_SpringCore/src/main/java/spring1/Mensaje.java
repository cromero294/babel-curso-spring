package spring1;

public class Mensaje {
	private int id;
	private String cuerpo;
	private String firma;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public String getFirma() {
		return firma;
	}
	public void setFirma(String firma) {
		this.firma = firma;
	}
	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", cuerpo=" + cuerpo + ", firma=" + firma + "]";
	}
}
