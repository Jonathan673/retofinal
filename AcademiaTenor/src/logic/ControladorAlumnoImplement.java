package logic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import model.Compra;
import model.Usuario;

public class ControladorAlumnoImplement implements ControladorAlumnoInterface{
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
		private final String SELECTcompras = "SELECT * FROM compra";

		public ControladorAlumnoImplement() {
			this.configFile = ResourceBundle.getBundle("logic.config");
			this.driverBD = configFile.getString("driver");
			this.urlBD = configFile.getString("con");
			this.userBD = configFile.getString("DBUSER");
			this.contraBD = configFile.getString("DBPASS");
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

		/////METODOS//////
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

		@Override
		public void comprarDocumentacion() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void cambiarCurso() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void listarAlumnosCurso() {
			// TODO Auto-generated method stub
			
		}

}
