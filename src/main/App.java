package main;


import logic.ControladorAdminImplement;
import logic.ControladorAdminInterface;

import view.VLogin;

public class App {

	public static void main(String[] args) {

		//
		
		ControladorAdminInterface datosAdmin = new ControladorAdminImplement();

		// Ventana
		VLogin vl = new VLogin(datosAdmin);
		vl.setVisible(true);
	}

}
