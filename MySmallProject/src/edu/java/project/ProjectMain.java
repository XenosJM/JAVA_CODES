package edu.java.project;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Rectangle;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class ProjectMain {

	protected JFrame frame;
	private static ManageDAO dao;
	private JOptionPane pane;
	MemberVO mv = new MemberVO();
	private JPasswordField inputPassword;
	private JTextField textInputId;
	
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
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setBounds(0, 0, 600, 400);
        frame.setLocation(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setAlwaysOnTop(true);

		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 584, 361);
		frame.getContentPane().add(loginPanel);
		loginPanel.setOpaque(false);
		loginPanel.setLayout(null);
		
		JButton btnSignUp = new JButton("회원가입");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpFrame signUp = new SignUpFrame();
				signUp.setVisible(true);

			}
		});
		btnSignUp.setBounds(475, 203, 97, 52);
		loginPanel.add(btnSignUp);
		
		JButton btnLogin = new JButton("사용 시작");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				memberLogin();
			}
		});
		
		btnLogin.setBounds(475, 265, 97, 86);
		loginPanel.add(btnLogin);
		
		JButton btnExit = new JButton("PC 종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		btnExit.setBounds(475, 153, 97, 40);
		loginPanel.add(btnExit);
		
		inputPassword = new JPasswordField();
		inputPassword.setEchoChar('*');
		inputPassword.setBounds(309, 313, 154, 40);
		loginPanel.add(inputPassword);
		
		textInputId = new JTextField();
		textInputId.setColumns(10);
		textInputId.setBounds(309, 265, 154, 38);
		loginPanel.add(textInputId);
		
		JLabel lblLogin = new JLabel("로그인 해주세요.");
		lblLogin.setFont(new Font("궁서체", Font.PLAIN, 28));
		lblLogin.setBounds(147, 93, 235, 100);
		loginPanel.add(lblLogin);

	} // end initialize()
	
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
				} else if (mv.getMemberTime() > 0) {
					MemberLogin login = new MemberLogin(); // 사용자일시 열릴 창
					login.setInfoFromPM(id, mv.getMemberNumber());
					login.setLblMember();
					login.currentTime();
					login.setVisible(true);
//					login.startTime();
					frame.setVisible(false);
					
				} else { // end managerId 체크
					pane.showMessageDialog(frame, "사용시간이 없습니다.");
				}

			} else {
				pane.showMessageDialog(frame, "비밀번호가 틀렸습니다.");
			} // end Pw 체크

		} else {
			pane.showMessageDialog(frame, "아이디가 틀렸습니다.");
		} // end id 체크

	}


} // end ProjectMain
