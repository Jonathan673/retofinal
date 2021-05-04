package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControladorUsuarioImplement implements ControladorUsuarioInterface {

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
	private final String SELECTpass = "SELECT password FROM usuario WHERE dni = ?";

	public ControladorUsuarioImplement() {
		this.configFile = ResourceBundle.getBundle("logic.config");
		this.driverBD = this.configFile.getString("driver");
		this.urlBD = this.configFile.getString("con");
		this.userBD = this.configFile.getString("DBUSER");
		this.contraBD = this.configFile.getString("DBPASS");
	}

	private void openConnnection() {
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

	//// METODOS DE LA INTERFAZ/////
	@Override
	public void insertarInstrumento() {
		// TODO Auto-generated method stub

	}

	@Override
	public void asignarInstrumento() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarDatosDelCurso() {
		// TODO Auto-generated method stub

	}

	@Override
	public void listarAlumno() {
		// TODO Auto-generated method stub

	}

	@Override
	public void listarCompras() {
		// TODO Auto-generated method stub

	}

	@Override
	public void comprarDocumentacion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cambiarCurso() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existeUsuario(String dni) {
		ResultSet rs;
		String pass = "";
		boolean existe = false;
		this.openConnnection();
		try {
			stmt = con.prepareStatement(SELECTpass);
			stmt.setString(1, dni);
			rs = stmt.executeQuery();
			if (rs.next()) {
				pass = rs.getString("password");
			}

//			System.out.println(rs.next());
//			System.out.println("pass -> " + pass);
			existe = !pass.equals("");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			System.out.println("error al cerrar la connection");
			e.printStackTrace();
		}
		return existe;
	}
}
