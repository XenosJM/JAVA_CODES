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
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ProjectMain {

	protected JFrame frame;
	private static ManageDAO dao;
	protected JTextField textInputId;
	protected JPasswordField inputPassword;

	MemberVO mv = new MemberVO();

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
		frame.setAlwaysOnTop(true);

		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 584, 361);
		frame.getContentPane().add(loginPanel);
		loginPanel.setOpaque(false);
		loginPanel.setLayout(null);

		JLabel lblLogin = new JLabel("로그인 해주세요.");
		lblLogin.setFont(new Font("궁서체", Font.PLAIN, 28));
		lblLogin.setBounds(12, -1, 235, 100);
		loginPanel.add(lblLogin);

		JButton btnSignUp = new JButton("회원가입");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpFrame signUp = new SignUpFrame();
				signUp.setVisible(true);

			}
		});
		btnSignUp.setBounds(475, 106, 97, 52);
		loginPanel.add(btnSignUp);

		JButton btnLogin = new JButton("사용 시작");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberLogin();
//				changePanel();

			} // end action
		});
		btnLogin.setBounds(475, 10, 97, 86);
		loginPanel.add(btnLogin);

		textInputId = new JTextField();
		textInputId.setBounds(309, 10, 154, 38);
		loginPanel.add(textInputId);
		textInputId.setColumns(10);

		inputPassword = new JPasswordField();
		inputPassword.setBounds(309, 56, 154, 40);
		loginPanel.add(inputPassword);

	} // end initialize()

	protected void memberInfo() {
		// TODO select
	}

	protected void memberLogin() {
		String id = textInputId.getText();
		char[] pwChar = inputPassword.getPassword();
		String pw = String.valueOf(pwChar);
		mv = dao.selectMem(id);
		int managerId = mv.getMemberManager();

		if (id.equals(mv.getMemberId())) {
			if (pw.equals(mv.getMemberPw())) {
				System.out.println("로그인 성공");
				if (managerId == 1) {
					ManagerLogin mgLogin = new ManagerLogin(); // 매니저일시 열릴 창
					mgLogin.setVisible(true);
					frame.setVisible(false);
				} else {
					//TODO 시간이 0일때 접속 못하게 바꿀것.
					MemberLogin login = new MemberLogin(); // 사용자일시 열릴 창
					login.setInfoFromPM(id, mv.getMemberNumber());
					login.setLblMember();
					login.currentTime();
					login.setVisible(true);
					frame.setVisible(false);
					login.startTime();
				} // end managerId 체크

			} else {
				System.out.println("비밀번호가 틀렸습니다.");
			} // end Pw 체크

		} else {
			System.out.println("아이디가 틀렸습니다.");
		} // end id 체크

	}

	// TODO 알림판 메인에서 처리

} // end ProjectMain
