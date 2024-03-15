package edu.java.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserUpdate extends JFrame {

	JFrame frame;
	private JPanel contentPane;
	protected JTextField textMemberName, textMemberPhone, textMemberEmail;
	protected JLabel lblMemberId, lblMemberPw, lblMemberName, lblMemberPhone, lblMemberEmail, lblMemberNum;
	protected JPasswordField inputPassword;
	protected JButton btnMemberUpdate;
	private static ManageDAO dao;
	private ProjectMain pm;
	private MemberLogin login;
	

	/**
	 * Create the frame.
	 * 
	 * @param text
	 */
	public UserUpdate() {
		dao = ManageDAOImple.getInstance();
		// JFrame.EXIT_ON_CLOSE : 프로그램 전체 종료
		// JFrame.DISPOSE_ON_CLOSE : 현재 창만 종료
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 356, 403);
//		  = this.setBounds(100, 100, 450, 300);
		contentPane = new JPanel(); // = Frame.getContantPane()과 동일
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnMemberUpdate = new JButton("회원 정보 수정");
		btnMemberUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login = new MemberLogin();
				String uuId = lblMemberId.getText();
				MemberVO mv = dao.selectMem(uuId);				
				login.setInfoFromPM(mv.getMemberId(), mv.getMemberNumber());
				login.refreshMem();
				updateMemUser();
				dispose();
			}
		});
		btnMemberUpdate.setBounds(164, 281, 170, 78);
		contentPane.add(btnMemberUpdate);

		textMemberName = new JTextField();
		textMemberName.setColumns(10);
		textMemberName.setBounds(147, 119, 187, 44);
		contentPane.add(textMemberName);

		textMemberPhone = new JTextField();
		textMemberPhone.setColumns(10);
		textMemberPhone.setBounds(147, 173, 187, 44);
		contentPane.add(textMemberPhone);

		textMemberEmail = new JTextField();
		textMemberEmail.setColumns(10);
		textMemberEmail.setBounds(147, 227, 187, 44);
		contentPane.add(textMemberEmail);

		lblMemberId = new JLabel("회원 아이디");
		lblMemberId.setBounds(12, 10, 123, 44);
		contentPane.add(lblMemberId);

		lblMemberPw = new JLabel("회원 비밀번호 변경 :");
		lblMemberPw.setBounds(12, 64, 123, 44);
		contentPane.add(lblMemberPw);

		lblMemberName = new JLabel("회원 이름 변경 :");
		lblMemberName.setBounds(12, 118, 123, 44);
		contentPane.add(lblMemberName);

		lblMemberPhone = new JLabel("회원 전화번호 변경 :");
		lblMemberPhone.setBounds(12, 172, 123, 44);
		contentPane.add(lblMemberPhone);

		lblMemberEmail = new JLabel("회원 이메일 변경 :");
		lblMemberEmail.setBounds(12, 225, 123, 44);
		contentPane.add(lblMemberEmail);

		inputPassword = new JPasswordField();
		inputPassword.setBounds(147, 65, 187, 44);
		contentPane.add(inputPassword);
		
		lblMemberNum = new JLabel("회원 번호");
		lblMemberNum.setBounds(198, 10, 59, 44);
		contentPane.add(lblMemberNum);

		// GuiMain11의 btn1과 비교해보면 더 쉽게 이해 가능
	}
	protected void updateMemUser() {
		// uu클래스에 있는 입력창에서 입력한걸 받아와서 쓰기위해선 uu클래스를 열어야하는데 그럴러면 new로 열어야해서 값들이 null로 초기화 된다.
		String id = lblMemberId.getText();
		char[] pwChar = inputPassword.getPassword();
		String pw = String.valueOf(pwChar);
		System.out.println(pw);
		String name = textMemberName.getText();
		System.out.println(name);
		String phone = textMemberPhone.getText();
		System.out.println(phone);
		String email = textMemberEmail.getText();
		System.out.println(email);
		MemberVO mv = new MemberVO(0, id, pw, name, phone, email, 0, 0);
		dao.updateMemUser(id, mv);
		System.out.println("수정 완료");
	}

	
}

