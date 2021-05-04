package model;

import java.time.LocalDate;

public class Usuario {

	private String dni;
	private String nombre;
	private String password;
	private int fijo;
	private int movil;
	private LocalDate fechaNac;
	private boolean admin;
		
	//metodos///
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getFijo() {
		return fijo;
	}
	public void setFijo(int fijo) {
		this.fijo = fijo;
	}
	public int getMovil() {
		return movil;
	}
	public void setMovil(int movil) {
		this.movil = movil;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	//to String
	@Override
	public String toString() {
		return "dni=" + dni + ", nombre=" + nombre + ", password=" + password + ", fijo=" + fijo + ", movil="
				+ movil + ", fechaNac=" + fechaNac + ", admin=" + admin + "]";
	}
	
	
	

}
