package logic;

import java.util.Map;

import model.Alumno;
import model.Compra;
import model.Curso;
import model.Instrumento;
import model.Profesor;

public interface ControladorProfesorInterface {
	///////// PROFESOR////////
	public void insertarInstrumento(Instrumento ins);

	public void asignarInstrumento();

	public void modificarDatosDelCurso(Curso curso);
	
	public Map<String, Alumno> listarAlumnosCurso(Curso cur);
	
	public Map<String, Compra> listarCompras();



}
