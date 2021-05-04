package logic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ResourceBundle;

import com.mysql.cj.xdevapi.Type;

import model.Documentacion;
import model.Usuario;

public class ControladorAdminImplement implements ControladorAdminInterface {

	// BBDD Tenor
	private Connection con;
	private PreparedStatement stmt;
	private CallableStatement cStmt;
	// fichero config.properties
	private ResourceBundle configFile;
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String contraBD;

	// Sentencias MSQL//
	private final String INSERTARusuario = "INSERT INTO usuario(dni, nombre, fijo, movil, password, fechanac, admin) VALUES (?,?,?,?,?,?,?)";
	private final String SELECTpass = "SELECT password FROM usuario WHERE dni = ?";
	private final String SELECTadmin = "SELECT admin FROM usuario WHERE dni = ?";
	private final String SELECTalum = "SELECT COUNT(*) FROM usuario u, alumno a WHERE u.dni = a.dni AND u.dni = ?";
	private final String SELECTprof = "";

	public ControladorAdminImplement() {
		this.configFile = ResourceBundle.getBundle("logic.config");
		this.driverBD = configFile.getString("driver");
		this.urlBD = configFile.getString("con");
		this.userBD = configFile.getString("DBUSER");
		this.contraBD = configFile.getString("DBPASS");
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

	///// METODOS DE LA INTERFAZ/////
	@Override
	public void crearUsuario(Usuario usu) {
		this.openConnnection();
		try {
			stmt = con.prepareStatement(INSERTARusuario);
			stmt.setString(1, usu.getDni());
			stmt.setString(2, usu.getNombre());
			stmt.setInt(3, usu.getFijo());
			stmt.setInt(4, usu.getMovil());
			stmt.setString(5, usu.getPassword());
			stmt.setDate(6, Date.valueOf(usu.getFechaNac()));
			// el admin ya esta introducido y es unico admin
			stmt.setBoolean(7, false);
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

	@Override
	public void modificarUsuario(Usuario usu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarUsuario(Usuario usu) {
		// TODO Auto-generated method stub

	}
	@Override
	public String login(String dni, String password) {
		ResultSet rs;
		ResultSet rsUsu;
		String pass = "";
		String tipoUsu = "";
		this.openConnnection();
		try {
			stmt = con.prepareStatement(SELECTpass);
			stmt.setString(1, dni);
			rs = stmt.executeQuery();
			// Llamada al Procedimiento Almacenado
			cStmt = con.prepareCall("{CALL tipo_usuario(?)}");
			cStmt.setString(1, dni);
			cStmt.execute();
			rsUsu = cStmt.getResultSet();
			if (rs.next()) {
				pass = rs.getString("password");
			}
			// Si la contraseña es correcta...
			if (pass.equals(password)) {
				if (rsUsu.next()) {
					tipoUsu = rsUsu.getString(1);
					System.out.println("Tipo usuario (Controlador) -> " + tipoUsu);
				}
			}
			// System.out.println(rs.next());
			System.out.println("pass -> " + pass);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			System.out.println("error al cerrar la connection");
			e.printStackTrace();
		}
		return tipoUsu;
	}

	// --------------------EXISTE USUARIO--------------------//
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

	// -------------------AÑADIR DOCUMENTACIÓN-------------------//
	@Override
	public void anadirDocumentacion(Documentacion docu) {
		// TODO Auto-generated method stub

	}
}
