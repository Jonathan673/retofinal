package model;

import java.time.LocalDate;

public class Documentacion {
	//
	private String codDocumentacion;
	private String titulo;
	private String dniAdmin;
	private LocalDate fechaPubli;
	
	//getters and setters
	public String getCodDocumentacion() {
		return codDocumentacion;
	}
	public void setCodDocumentacion(String codDocumentacion) {
		this.codDocumentacion = codDocumentacion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDniAdmin() {
		return dniAdmin;
	}
	public void setDniAdmin(String dniAdmin) {
		this.dniAdmin = dniAdmin;
	}
	public LocalDate getFechaPubli() {
		return fechaPubli;
	}
	public void setFechaPubli(LocalDate fechaPubli) {
		this.fechaPubli = fechaPubli;
	}
	
	//to String 
	@Override
	public String toString() {
		return "Documentacion [codDocumentacion=" + codDocumentacion + ", titulo=" + titulo + ", dniAdmin=" + dniAdmin
				+ ", fechaPubli=" + fechaPubli + "]";
	}
	
	
}
