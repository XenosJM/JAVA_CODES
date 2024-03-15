package edu.java.project;

import java.awt.EventQueue;
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
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class ManagerMemberUpdate extends JFrame {
	JFrame frame;
	private JPanel contentPane;
	protected JTextField textMemberName, textMemberPhone, textMemberEmail;
	protected JLabel lblMemberId, lblMemberPw, lblMemberName, lblMemberPhone, lblMemberEmail, lblMemberNum;
	protected JPasswordField inputPassword;
	protected JButton btnMemberUpdate, btnCheck;
	private JRadioButton rdbtnManagerTrue, rdbtnManagerFalse;
	private static ManageDAO dao;
	private ProjectMain pm;
	private MemberLogin login;
	private JLabel lblMemberManagerId;
	private JLabel lblManagerTip;
	
	public ManagerMemberUpdate() {
		
	dao=ManageDAOImple.getInstance();
	
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 357, 462);
//	  = this.setBounds(100, 100, 450, 300);
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
	btnMemberUpdate.setBounds(147, 335, 187, 78);
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
	lblMemberManagerId.setBounds(12, 279, 76, 44);
	contentPane.add(lblMemberManagerId);
	
	rdbtnManagerTrue = new JRadioButton("관리자 기능 켜짐(on)");
	rdbtnManagerTrue.setBounds(96, 277, 141, 23);
	contentPane.add(rdbtnManagerTrue);
	
	rdbtnManagerFalse = new JRadioButton("관리자 기능 꺼짐(off)");
	rdbtnManagerFalse.setBounds(96, 306, 141, 23);
	contentPane.add(rdbtnManagerFalse);
	
	btnCheck = new JButton("확인");
    btnCheck.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
      	 int ManagerTrue = 1;
      	 int ManagerFalse = 0;
      	 if(rdbtnManagerTrue.isSelected()) {
//      		textArea.setText(male);
      	 } else {
//      		 textArea.setText(female);
      	 }
       }
    });
    btnCheck.setBounds(245, 281, 84, 44);
    contentPane.add(btnCheck);
    
    JTextArea textArea = new JTextArea();
    textArea.setFocusable(false);
    textArea.setText("관리자기능 사용\r\n여부를 선택하시고 \r\n확인버튼을 누르세요.");
    textArea.setBounds(12, 335, 123, 78);
    contentPane.add(textArea);
    
 


	// GuiMain11의 btn1과 비교해보면 더 쉽게 이해 가능
}

	protected void updateMemUser() {
		// uu클래스에 있는 입력창에서 입력한걸 받아와서 쓰기위해선 uu클래스를 열어야하는데 그럴러면 new로 열어야해서 값들이 null로 초기화
		// 된다.
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
