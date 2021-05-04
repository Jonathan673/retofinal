package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.ControladorAdminImplement;
import model.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VAdmin extends JFrame {

	private JPanel contentPane;
	private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();;
	private int centerX;
	private int centerY;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VAdmin frame = new VAdmin();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param usu 
	 * @param b 
	 * @param vAdmin 
	 */
	public VAdmin(ControladorAdminImplement admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin");
		//setBounds(100, 100, 1000, 680);
//		setBounds(100,100,1024,600);
		setBounds(100,100,1080,810);
		centerX = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		centerY = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		setLocation(centerX, centerY);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				 int screenX = me.getXOnScreen();
				    int screenY = me.getYOnScreen();
				    System.out.println("screen(X,Y) = " + screenX + "," + screenY);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin PAP\u00C1");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 40));
		lblNewLabel.setBounds(380, 184, 308, 139);
		contentPane.add(lblNewLabel);
		
		JButton btnBorrarUsu = new JButton("Borrar");
		btnBorrarUsu.setForeground(Color.BLACK);
		btnBorrarUsu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBorrarUsu.setBounds(675, 528, 211, 73);
		contentPane.add(btnBorrarUsu);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModificar.setBounds(675, 364, 211, 73);
		contentPane.add(btnModificar);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearUsuario(admin);
			}


		});
		btnCrearUsuario.setForeground(Color.BLACK);
		btnCrearUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCrearUsuario.setBounds(141, 364, 211, 73);
		contentPane.add(btnCrearUsuario);
		
		JButton btnAddDoc = new JButton("A\u00F1adir Documentaci\u00F3n");
		btnAddDoc.setForeground(Color.BLACK);
		btnAddDoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddDoc.setBounds(141, 528, 211, 73);
		contentPane.add(btnAddDoc);
	}

	///////Metodos ////////////
	private void crearUsuario(ControladorAdminImplement admin) {
		// TODO Auto-generated method stub
		Usuario usu = null;
		VCrearUser usuAlta = new VCrearUser(this, true,usu,admin);
		usuAlta.setVisible(true);	
	}
}
