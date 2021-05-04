package logic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import model.Alumno;
import model.Compra;
import model.Curso;
import model.Documentacion;
import model.Instrumento;
import model.Profesor;
import model.Usuario;

public class ControladorProfesorImplement implements ControladorProfesorInterface {

	// Fichero
	private Connection con;
	private PreparedStatement stmt;
	// fichero config.properties
	private ResourceBundle configFile;
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String contraBD;
	// Sentencias MSQL//
	private final String INSERTARinstrumento = "INSERT INTO instrumento(codins,tipo,nombre) VALUES (?,?,?)";
	private final String MODIFICARcurso = "UPDATE curso SET nombrecur = ?, horas = ? where codcurso = ?";
	private final String SELECTalumnos = "SELECT DISTINCT u.nombre, a.* FROM alumno a, cursa c, curso co, usuario u WHERE (a.dni=c.dnialum AND c.codcurso=co.codcurso AND a.dni=u.dni) AND co.nombrecur=?";
	private final String SELECTcompras = "SELECT * FROM compra";
	/////////

	public ControladorProfesorImplement() {
		this.configFile = ResourceBundle.getBundle("logic.config");
		this.driverBD = this.configFile.getString("driver");
		this.urlBD = this.configFile.getString("con");
		this.userBD = this.configFile.getString("DBUSER");
		this.contraBD = this.configFile.getString("DBPASS");
	}

	private void openConnection() {
		try {

			con = DriverManager.getConnection(this.urlBD, this.userBD, this.contraBD);

		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
	}

	private void closeConnection() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null)
			con.close();
	}

	/// METODOS///

	//////////////////////// INSERTAR
	//////////////////////// INSTRUMENTOS/////////////////////////////////////
	@Override
	public void insertarInstrumento(Instrumento ins) {
		this.openConnection();
		try {
			stmt = con.prepareStatement(INSERTARinstrumento);
			stmt.setString(1, ins.getCodInstrumento());
			stmt.setString(2, ins.getNombreInstrumento());
			stmt.setString(3, ins.getTipo());
			stmt.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			System.out.println("error al cerrar la connection");
			e.printStackTrace();
		}

	}

	//////////////////////// ASIGNAR
	//////////////////////// INSTRUMENTOS/////////////////////////////////////
	@Override
	public void asignarInstrumento() {
		// TODO Auto-generated method stub

	}

	//////////////////////// MODIFICAR DATOS DEL
	//////////////////////// CURSO/////////////////////////////////////
	@Override
	public void modificarDatosDelCurso(Curso curso) {
		this.openConnection();
		try {
			stmt = con.prepareStatement(MODIFICARcurso);
			stmt.setString(1, curso.getNombreCurso());
			stmt.setInt(2, curso.getHoras());
			stmt.setString(3, curso.getCodCurso());
			stmt.executeUpdate();

		} catch (SQLException e1) {
			System.out.println("ERROR al modificar datosCoche SQL");
			e1.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			System.out.println("ERROR al cerrar SQL");
			e.printStackTrace();
		}

	}

	//////////////////////// LISTAR ALUMNOS POR
	//////////////////////// CURSO/////////////////////////////////////
	@Override
	public Map<String, Alumno> listarAlumnosCurso(Curso cur) {
		Map<String, Alumno> alumnos = new TreeMap<>();
		Alumno al;

		ResultSet rs = null;// para el executeQuery

		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECTalumnos);// LA CONSULTA
			stmt.setString(1, "guitarra");
			rs = stmt.executeQuery();

			while (rs.next()) {
				al = new Alumno();

				al.setDni(rs.getString("dni"));
				al.setEdad(rs.getInt("edad"));
				alumnos.put(al.getDni(), al);
			}

		} catch (SQLException e1) {
			System.out.println("ERROR en busqueda SQL");
			e1.printStackTrace();
		}

		// se CIERRA RS
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("ERROR cierre RS");
				e.printStackTrace();
			}
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			System.out.println("Error en cierre SQL");
			e.printStackTrace();
		}

		return alumnos;

}

	//////////////////////// LISTAR
	//////////////////////// COMPRAS///////////////////////////////////////////////
	@Override
	public Map<String, Compra> listarCompras() {
		Map<String, Compra> compras = new TreeMap<>();
		Compra com;

		ResultSet rs = null;// para el executeQuery

		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECTcompras);

			rs = stmt.executeQuery();

			while (rs.next()) {
				com = new Compra();

				com.setCodDocumento(rs.getString("coddoc"));
				com.setDniAlumno(rs.getString("dnialum"));
				compras.put(com.getCodDocumento(), com);
			}

			System.out.println(compras.values());

		} catch (SQLException e1) {
			System.out.println("ERROR en busqueda SQL");
			e1.printStackTrace();
		}

		// se CIERRA RS
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("ERROR cierre RS");
				e.printStackTrace();
			}
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			System.out.println("Error en cierre SQL");
			e.printStackTrace();
		}

		return compras;

	}

}

///// METODOS DE LA INTERFAZ/////
