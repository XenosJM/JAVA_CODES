package edu.java.project;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
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
	 * @param text
	 */
	public SignUpFrame() {
		dao = ManageDAOImple.getInstance();
		// JFrame.EXIT_ON_CLOSE : 프로그램 전체 종료
		// JFrame.DISPOSE_ON_CLOSE : 현재 창만 종료
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 499, 515);
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
		btnMemberInsert.setBounds(301, 388, 170, 78);
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

		// TODO 밑에 4개 항목들 매니저 로그인시 활성화 되도록 코드 짜기
		JLabel lblMemberTime = new JLabel("회원 남은 시간");
		lblMemberTime.setBounds(12, 280, 187, 44);
		lblMemberTime.setVisible(false);
		contentPane.add(lblMemberTime);

		JComboBox<String> boxMemberTime = new JComboBox<String>();
		boxMemberTime.setBounds(211, 280, 187, 44);
		boxMemberTime.addItem("시간 선택");
		boxMemberTime.addItem("1시간 추가");
		boxMemberTime.addItem("3시간 추가");
		boxMemberTime.addItem("5시간 추가");
		boxMemberTime.addItem("10시간 추가");
		boxMemberTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectItem = (String) boxMemberTime.getSelectedItem();
				switch (selectItem) {

				case "1시간 추가": 
					break;
				case "3시간 추가": 
					break;
				case "5시간 추가": 
					break;
				case "10시간 추가": 
					break;
				default:
					break;
				}

			}
		});
		boxMemberTime.setVisible(true);
		contentPane.add(boxMemberTime);

		JLabel lblMemberManagerId = new JLabel("관리자 설정");
		lblMemberManagerId.setBounds(12, 334, 187, 44);
		lblMemberManagerId.setVisible(false);
		contentPane.add(lblMemberManagerId);

		JComboBox<String> comboBoxManager = new JComboBox<String>();
		comboBoxManager.setBounds(211, 334, 187, 44);
		comboBoxManager.addItem("관리자 여부 선택");
		comboBoxManager.addItem("관리자 기능 허용");
		comboBoxManager.addItem("관리자 기능 비허용");
		comboBoxManager.setVisible(false);
		contentPane.add(comboBoxManager);

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
		int result = dao.insertMem(mv);

	}

}
