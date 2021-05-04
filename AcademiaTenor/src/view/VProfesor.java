package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.ControladorProfesorImplement;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class VProfesor extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	private int centerX;
	private int centerY;
	private JButton btnInsertarIns,btnAsignarIns,btnListarCompras,btnListarAlumCurso,btnModificarDatosCurso;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VProfesor frame = new VProfesor();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VProfesor(ControladorProfesorImplement datosProfe) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Profesor");
		setBounds(100,100,1080,810);
		centerX = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		centerY = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		setLocation(centerX, centerY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblProfesor.setBounds(454, 34, 117, 87);
		contentPane.add(lblProfesor);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(767, 22, 247, 14);
		contentPane.add(lblNombre);
		
		btnInsertarIns = new JButton("Insertar Instrumento");
		btnInsertarIns.setBounds(429, 155, 144, 60);
		btnInsertarIns.addActionListener(this);
		contentPane.add(btnInsertarIns);
		
		btnAsignarIns = new JButton("Asignar Instrumento");
		btnAsignarIns.setBounds(429, 308, 142, 60);
		btnAsignarIns.addActionListener(this);
		contentPane.add(btnAsignarIns);
		
		btnListarCompras = new JButton("Listar Compras");
		btnListarCompras.setBounds(429, 467, 142, 60);
		btnListarCompras.addActionListener(this);
		contentPane.add(btnListarCompras);
		
		btnListarAlumCurso = new JButton("Listar Alumnos Curso");
		btnListarAlumCurso.setBounds(159, 308, 144, 60);
		btnListarAlumCurso.addActionListener(this);
		contentPane.add(btnListarAlumCurso);
		
		btnModificarDatosCurso = new JButton("Modificar Datos Curso");
		btnModificarDatosCurso.setBounds(722, 308, 137, 60);
		btnModificarDatosCurso.addActionListener(this);
		contentPane.add(btnModificarDatosCurso);
	}

	//////////////////METODOS//////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnInsertarIns)) {
			VInsertarIns ven = new VInsertarIns(this, true);
			ven.setVisible(true);
		}
		
	}
}
