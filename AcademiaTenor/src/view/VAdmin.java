package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	 */
	public VAdmin() {
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
