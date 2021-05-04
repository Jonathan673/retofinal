package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import logic.ControladorAdminInterface;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class VLogin extends JFrame{

	private JPanel contentPane;
	private JTextField tfDNI;
	private JPasswordField pfPass;
	private String dni;
	private String password;
	private JLabel lblErrorDNI;
	private JLabel lblErrorPass;
	private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();;
	private int centerX = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	private int centerY = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	private String usuario;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VLogin frame = new VLogin();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 * @param datosUser
	 * @param datosAdmin
	 */
	public VLogin(ControladorAdminInterface datosAdmin) {
		// setLocationRelativeTo(GraphicsEnvironment.);
		setBounds(100, 100, 480, 480);
		setResizable(false);
		centerX = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		centerY = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		setLocation(centerX, centerY);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		try {
			setIconImage(ImageIO.read(new File("img/logo4.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//-------------BOTÓN LOGIN -------------//
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dni = tfDNI.getText();
				password = new String(pfPass.getPassword());
				System.out.println("password window -> " + password);
				//Si no se han introducido datos el botón de login está deshabilitado
				if(tfDNI.getText().isEmpty() || pfPass.getPassword().length == 0) {
					btnLogin.setEnabled(false);
				}else if (!datosAdmin.login(dni, password).equals("")) {
					usuario = datosAdmin.login(dni, password);
					if(usuario.equals("admin")){
						VAdmin va = new VAdmin();
						va.setVisible(true);
						dispose();
					}
					if(usuario.equals("alumno")) {
						VAlumno val = new VAlumno();
						val.setVisible(true);
						dispose();
					}
					if(usuario.equals("profesor")) {
						VProfesor vp = new VProfesor();
						vp.setVisible(true);
						dispose();
					}
					
				} else {
					lblErrorPass.setText("*");
					pfPass.setText("");
					System.out.println("Incorrecto");
				};
			}
		});
		btnLogin.setBounds(167, 322, 140, 40);
		contentPane.add(btnLogin);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDNI.setBounds(65, 130, 46, 14);
		contentPane.add(lblDNI);

		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(65, 217, 74, 14);
		contentPane.add(lblPassword);
		
		//------------------DNI------------------//
		tfDNI = new JTextField();
		tfDNI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				dni = tfDNI.getText();
				//si el campo del dni esta vacío...
				if (tfDNI.getText().length() == 0) {
					lblErrorDNI.setText("*");
					tfDNI.setBorder(BorderFactory.createLineBorder(Color.gray));
				} 
				//si el campo se ha añadido incorrectamente..
				else if (!datosAdmin.existeUsuario(dni)) {
					lblErrorDNI.setText("*");
					lblErrorDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblErrorDNI.setBackground(Color.RED);
					pfPass.transferFocusBackward();
					
				}
				//Si El dni introducido es correcto...
				else {
					btnLogin.setEnabled(true);
					tfDNI.setBorder(BorderFactory.createLineBorder(Color.green));
				}
			}

		});
		tfDNI.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				lblErrorDNI.setText("");
				if (tfDNI.getText().length() >= 9) // el usuario no puede introducir más de 9 caracteres
					e.consume();
			}
		});
		tfDNI.setBounds(167, 127, 140, 25);
		tfDNI.setBorder(BorderFactory.createLineBorder(Color.gray));
		contentPane.add(tfDNI);
		tfDNI.setColumns(10);
		
		//-------------CONTRASEÑA-------------//
		pfPass = new JPasswordField();
		pfPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblErrorPass.setText("");
			}
		});
		pfPass.setBounds(167, 204, 140, 25);
		pfPass.setBorder(BorderFactory.createLineBorder(Color.gray));
		contentPane.add(pfPass);

		//-------------ERROR DNI -------------//
		lblErrorDNI = new JLabel("");
		lblErrorDNI.setForeground(Color.RED);
		lblErrorDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorDNI.setBounds(303, 63, 100, 14);
		contentPane.add(lblErrorDNI);

		//-------------ERROR CONTRASEÑA -------------//
		lblErrorPass = new JLabel("");
		lblErrorPass.setForeground(Color.RED);
		lblErrorPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorPass.setBounds(303, 116, 133, 14);
		lblErrorPass.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				lblErrorPass.setText("");
				e.consume();
			}
		});
		contentPane.add(lblErrorPass);
	}
}
