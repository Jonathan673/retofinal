package model;

import java.time.LocalDate;

public class Cursa {
	//
	private String dniAlumno;
	private String dniProfesor;
	private String codCurso;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
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
	public String getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	//to String
	@Override
	public String toString() {
		return "Cursa [dniAlumno=" + dniAlumno + ", dniProfesor=" + dniProfesor + ", codCurso=" + codCurso
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	
}
