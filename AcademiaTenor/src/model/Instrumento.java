package model;

public class Instrumento {
	//
	private String codInstrumento;
	private String tipo;
	private String nombreInstrumento;
	
	//getters and setters
	public String getCodInstrumento() {
		return codInstrumento;
	}
	public void setCodInstrumento(String codInstrumento) {
		this.codInstrumento = codInstrumento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombreInstrumento() {
		return nombreInstrumento;
	}
	public void setNombreInstrumento(String nombreInstrumento) {
		this.nombreInstrumento = nombreInstrumento;
	}
	
	//to String 
	@Override
	public String toString() {
		return "Instrumento [codInstrumento=" + codInstrumento + ", tipo=" + tipo + ", nombreInstrumento="
				+ nombreInstrumento + "]";
	}
	
	
}
