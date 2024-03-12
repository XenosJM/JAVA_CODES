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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import oracle.jdbc.driver.T2CConnection;

import javax.swing.JPasswordField;

public class ProjectMain {

	private JFrame frame;
	private static ManageDAO dao;
	private JTextField textInputId;
	private JPasswordField InputPassword;
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
		panel.setOpaque(false);
		panel.setBounds(0, 0, 584, 361);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("로그인 해주세요.");
		lblLogin.setFont(new Font("궁서체", Font.PLAIN, 28));
		lblLogin.setBounds(100, 10, 400, 100);
		panel.add(lblLogin);
		
		JButton btnSignUp = new JButton("회원가입");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpFrame signUp = new SignUpFrame();
				signUp.setVisible(true);
				
			}
		});
		btnSignUp.setBounds(475, 203, 97, 52);
		panel.add(btnSignUp);
		
		JButton btnLogIn = new JButton("로그인");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberLogin login = new MemberLogin();
				login.setVisible(true);
				
			}
		});
		btnLogIn.setBounds(475, 265, 97, 86);
		panel.add(btnLogIn);
		
		textInputId = new JTextField();
		textInputId.setBounds(309, 265, 154, 38);
		panel.add(textInputId);
		textInputId.setColumns(10);
		
		InputPassword = new JPasswordField();
		InputPassword.setBounds(309, 311, 154, 40);
		panel.add(InputPassword);
		
		// 
//		String[] pairs = hv.getHistMem().split(", "); // 쉼표와 공백을 기준으로 나눔
//
//		for (String pair : pairs) {
//			String[] Column = pair.split(": "); // 콜론과 공백을 기준으로 나눔
//			String Name = Column[0].trim();
//			String Value = Column[1].trim();
//			System.out.println("컬럼 : " + Name + " 값 : " + Value);
//		}
		
	} // end initialize()
	
		
		
} // end ProjectMain
