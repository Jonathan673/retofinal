package model;

public class Curso {
	//variables
	private String codCurso;
	private String nombreCurso;
	private int horas;
	
	
	//getters and setters
	public String getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	//to String
	@Override
	public String toString() {
		return "Curso [codCurso=" + codCurso + ", nombreCurso=" + nombreCurso + ", horas=" + horas + "]";
	}
	
	
}
