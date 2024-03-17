package edu.java.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class ManagerMemberUpdate extends JFrame {
	JFrame frame;
	private JPanel contentPane;
	protected JTextField textMemberName, textMemberPhone, textMemberEmail;
	protected JLabel lblMemberId, lblMemberPw, lblMemberName, lblMemberPhone, lblMemberEmail, lblMemberNum;
	protected JPasswordField inputPassword;
	protected JButton btnMemberUpdate;
	private static ManageDAO dao;
	private JLabel lblMemberManagerId;
	private JButton btnMemberUpdateCancel;
	private JComboBox comboBoxMemberManager, comboBoxMemberTime;
	private int memberManager, addTime;
	private JLabel lblMemberTime;

	public ManagerMemberUpdate() {

		dao = ManageDAOImple.getInstance();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 357, 520);
//	  = this.setBounds(100, 100, 450, 300);
		contentPane = new JPanel(); // = Frame.getContantPane()과 동일
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnMemberUpdate = new JButton("회원 정보 수정");
		btnMemberUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxMemberTime.getSelectedItem().equals("1시간 요금제 추가")) {
					addTime = 3600;
					if (comboBoxMemberTime.getSelectedItem().equals("3시간 요금제 추가")) {
						addTime = 10800;
						if (comboBoxMemberTime.getSelectedItem().equals("5시간 요금제 추가")) {
							addTime = 18000;
							if (comboBoxMemberTime.getSelectedItem().equals("10시간 요금제 추가")) {
								addTime = 36000;
								if (comboBoxMemberTime.getSelectedItem().equals("20시간 요금제 추가")) {
									addTime = 72000;
								}

							}
						}
					}
				}
				if (comboBoxMemberManager.getSelectedItem().equals("관리자 기능 켜기")) {
					memberManager = 1;
					if (comboBoxMemberManager.getSelectedItem().equals("관리자 기능 끄기")) {
						memberManager = 0;
						
					}
				}
				System.out.println(memberManager);
				updateMemManager();
				dispose();
			}
		});
		btnMemberUpdate.setBounds(147, 393, 187, 33);
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

		lblMemberManagerId = new JLabel("매니저 여부");
		lblMemberManagerId.setBounds(12, 339, 76, 44);
		contentPane.add(lblMemberManagerId);

		btnMemberUpdateCancel = new JButton("회원 정보 수정 취소");
		btnMemberUpdateCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnMemberUpdateCancel.setBounds(147, 437, 187, 33);
		contentPane.add(btnMemberUpdateCancel);

		comboBoxMemberManager = new JComboBox();
		comboBoxMemberManager.addItem("관리자 기능 끄기");
		comboBoxMemberManager.addItem("관리자 기능 켜기");
		comboBoxMemberManager.setBounds(147, 339, 187, 44);
		contentPane.add(comboBoxMemberManager);

		lblMemberTime = new JLabel("회원 시간 추가 :");
		lblMemberTime.setBounds(12, 279, 123, 44);
		contentPane.add(lblMemberTime);

		comboBoxMemberTime = new JComboBox();
		comboBoxMemberTime.setBounds(147, 281, 187, 44);
		comboBoxMemberTime.addItem("추가할 요금제 선택");
		comboBoxMemberTime.addItem("1시간 요금제 추가");
		comboBoxMemberTime.addItem("3시간 요금제 추가");
		comboBoxMemberTime.addItem("5시간 요금제 추가");
		comboBoxMemberTime.addItem("10시간 요금제 추가");
		comboBoxMemberTime.addItem("20시간 요금제 추가");
		contentPane.add(comboBoxMemberTime);

		// GuiMain11의 btn1과 비교해보면 더 쉽게 이해 가능
	}

	protected void updateMemManager() {
		String id = lblMemberId.getText();
		MemberVO tmv = dao.selectMem(id);
		char[] pwChar = inputPassword.getPassword();
		String pw = String.valueOf(pwChar);
		System.out.println(pw);
		String name = textMemberName.getText();
		System.out.println(name);
		String phone = textMemberPhone.getText();
		System.out.println(phone);
		String email = textMemberEmail.getText();
		System.out.println(email);
		System.out.println("addTime = " + addTime);
		MemberVO mv = new MemberVO(0, id, pw, name, phone, email, tmv.getMemberTime()+addTime, memberManager);
		dao.updateMem(id, mv);
		System.out.println("수정 완료");
	}
}
