package model;

public class Alumno extends Usuario {
	//
	private int edad;

	// getters and setters////
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	// to String////////
	@Override
	public String toString() {
		return "Alumno [" + super.toString() + "edad=" + edad + "]";
	}

}
