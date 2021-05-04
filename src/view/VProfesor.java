package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VProfesor extends JFrame {

	private JPanel contentPane;
	private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	private int centerX;
	private int centerY;

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
	public VProfesor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Profesor");
		setBounds(100,100,1080,810);
		centerX = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		centerY = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		setLocation(centerX, centerY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
