package edu.java.project;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectMain {

	private JFrame frame;
	private static ManageDAO dao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dao = ManageDAOImple.getInstance();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectMain window = new ProjectMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); // end Thread
	} // end main()

	
	/**
	 * Create the application.
	 */
	public ProjectMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int x = (screenWidth - 600) / 2;
        int y = (screenHeight - 400) / 2;
        frame.setBounds(100, 100, 600, 400);
        frame.setLocation(x, y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 361);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("로그인방법을 선택하세요.");
		lblLogin.setFont(new Font("궁서체", Font.PLAIN, 28));
		lblLogin.setBounds(100, 10, 400, 100);
		panel.add(lblLogin);
		
		
		
	} // end initialize()
} // end ProjectMain
