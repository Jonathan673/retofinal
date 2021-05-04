package logic;

import model.Documentacion;
import model.Usuario;

public interface ControladorAdminInterface {

	///////// ADMIN//////////
	public void crearUsuario(Usuario usu);

	public void modificarUsuario(Usuario usu);

	public void borrarUsuario(Usuario usu);

	public void anadirDocumentacion(Documentacion docu);

	public boolean existeUsuario(String dni);
	
	/**
	 * Método para loggearse en la aplicación.  
	 * @autor Alex Hurtado
	 * @param dni -> El dni del usuario.
	 * @param password -> La contraseña del usuario.
	 * @return Si el usuario introduce bien su usuario y contraseña 
	 * devuelve una cadena con el tipo de usuario que es ("admin", "alumno", "profesor")
	 * */
	public String login(String dni, String password);

}
