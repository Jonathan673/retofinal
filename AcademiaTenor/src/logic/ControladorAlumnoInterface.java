package logic;

import java.util.Map;

import model.Compra;

public interface ControladorAlumnoInterface {
///////// ALUMNO//////////
public Map<String, Compra> listarCompras();

public void comprarDocumentacion();

public void cambiarCurso();

public void listarAlumnosCurso();

}
