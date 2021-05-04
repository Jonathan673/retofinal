package model;

public class Compra {
	//
	private String dniAlumno;
	private String codDocumento;
	
	//getters and setters
	public String getDniAlumno() {
		return dniAlumno;
	}
	public void setDniAlumno(String dniAlumno) {
		this.dniAlumno = dniAlumno;
	}
	public String getCodDocumento() {
		return codDocumento;
	}
	public void setCodDocumento(String codDocumento) {
		this.codDocumento = codDocumento;
	}
	
	//to String 
	@Override
	public String toString() {
		return "Compra [dniAlumno=" + dniAlumno + ", codDocumento=" + codDocumento + "]";
	}
	
	
}
