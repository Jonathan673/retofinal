package model;

public class Profesor extends Usuario {

	private String titulacion;

	// getters and setters///
	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	// to String///////////////
	@Override
	public String toString() {
		return "Profesor [" + super.toString() + ", titulacion=" + titulacion + "]";
	}

}
