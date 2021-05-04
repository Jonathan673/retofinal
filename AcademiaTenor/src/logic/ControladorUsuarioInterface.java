package logic;

public interface ControladorUsuarioInterface {

	///////// PROFESOR////////
	public void insertarInstrumento();

	public void asignarInstrumento();

	public void modificarDatosDelCurso();

	public void listarAlumno();

	///////// ALUMNO//////////
	public void listarCompras();

	public void comprarDocumentacion();

	public void cambiarCurso();

	public boolean existeUsuario(String dni);

}
