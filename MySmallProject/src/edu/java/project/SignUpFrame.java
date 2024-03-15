package edu.java.project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textInputId;
	private JTextField textMemberName;
	private JTextField textMemberPhone;
	private JTextField textMemberEmail;
	private JPasswordField inputPassword;
	private static ManageDAO dao;
	/**
	 * Create the frame.
	 * 
	 */
	public SignUpFrame() {
		dao = ManageDAOImple.getInstance();
		// JFrame.EXIT_ON_CLOSE : 프로그램 전체 종료
		// JFrame.DISPOSE_ON_CLOSE : 현재 창만 종료
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 422, 407);
//	  = this.setBounds(100, 100, 450, 300);
		contentPane = new JPanel(); // = Frame.getContantPane()과 동일
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnMemberInsert = new JButton("회원 가입완료");
		btnMemberInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertMem();
				dispose();
			}
		});
		btnMemberInsert.setBounds(228, 280, 170, 78);
		contentPane.add(btnMemberInsert);

		textInputId = new JTextField();
		textInputId.setBounds(211, 11, 187, 44);
		contentPane.add(textInputId);
		textInputId.setColumns(10);

		textMemberName = new JTextField();
		textMemberName.setColumns(10);
		textMemberName.setBounds(211, 118, 187, 44);
		contentPane.add(textMemberName);

		textMemberPhone = new JTextField();
		textMemberPhone.setColumns(10);
		textMemberPhone.setBounds(211, 172, 187, 44);
		contentPane.add(textMemberPhone);

		textMemberEmail = new JTextField();
		textMemberEmail.setColumns(10);
		textMemberEmail.setBounds(211, 226, 187, 44);
		contentPane.add(textMemberEmail);

		JLabel lblMemberId = new JLabel("회원 아이디");
		lblMemberId.setBounds(12, 10, 187, 44);
		contentPane.add(lblMemberId);

		JLabel lblMemberPw = new JLabel("회원 비밀번호");
		lblMemberPw.setBounds(12, 65, 187, 44);
		contentPane.add(lblMemberPw);

		JLabel lblMemberName = new JLabel("회원 이름");
		lblMemberName.setBounds(12, 118, 187, 44);
		contentPane.add(lblMemberName);

		JLabel lblMemberPhone = new JLabel("회원 전화번호");
		lblMemberPhone.setBounds(12, 172, 187, 44);
		contentPane.add(lblMemberPhone);

		JLabel lblMemberEmail = new JLabel("회원 이메일");
		lblMemberEmail.setBounds(12, 226, 187, 44);
		contentPane.add(lblMemberEmail);

		inputPassword = new JPasswordField();
		inputPassword.setBounds(211, 65, 187, 44);
		contentPane.add(inputPassword);

		// GuiMain11의 btn1과 비교해보면 더 쉽게 이해 가능
	}

	public void insertMem() {
		String Id = textInputId.getText();
		char[] PwChar = inputPassword.getPassword();
		String Pw = String.valueOf(PwChar);
		String name = textMemberName.getText();
		String phone = textMemberPhone.getText();
		String email = textMemberEmail.getText();

		MemberVO mv = new MemberVO(0, Id, Pw, name, phone, email, 0, 0);
		dao.insertMem(mv);

	}

}
