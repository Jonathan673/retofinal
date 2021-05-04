package model;

public class Alquila {
	//
	private String dniAlumno;
	private String dniProfesor;
	private String codInstrumento;
	
	//getters and setters
	public String getDniAlumno() {
		return dniAlumno;
	}
	public void setDniAlumno(String dniAlumno) {
		this.dniAlumno = dniAlumno;
	}
	public String getDniProfesor() {
		return dniProfesor;
	}
	public void setDniProfesor(String dniProfesor) {
		this.dniProfesor = dniProfesor;
	}
	public String getCodInstrumento() {
		return codInstrumento;
	}
	public void setCodInstrumento(String codInstrumento) {
		this.codInstrumento = codInstrumento;
	}
	
	//to String
	@Override
	public String toString() {
		return "Alquila [dniAlumno=" + dniAlumno + ", dniProfesor=" + dniProfesor + ", codInstrumento=" + codInstrumento
				+ "]";
	}
	
	
}
