package edu.java.project;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CheckPw extends JFrame {

	private ManageDAO dao;
	private JLabel lblNotice;
	private JPasswordField passwordField;
	private final JPanel contentPanel = new JPanel();
	private MemberLogin login;
	private JTextField textInputId;
	private UserUpdate uu;
	private JFrame frame;
	private JOptionPane pane;
	protected JButton okButton, cancelButton;
	
	public CheckPw() {
		dao = ManageDAOImple.getInstance();
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);

		lblNotice = new JLabel("본인확인을 위해 다시 한번 로그인해주세요");
		lblNotice.setBounds(97, 24, 240, 40);
		getContentPane().add(lblNotice);

		passwordField = new JPasswordField();
		passwordField.setBounds(97, 127, 240, 40);
		getContentPane().add(passwordField);
		textInputId = new JTextField();

		textInputId.setBounds(97, 74, 240, 40);
		getContentPane().add(textInputId);
		textInputId.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 228, 434, 33);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane);

		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cheking();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}

	protected void cheking() {
		String id = textInputId.getText();
//		System.out.println("String id : " + id);
		char[] pwChar = passwordField.getPassword();
		String pw = String.valueOf(pwChar);
//		System.out.println("mv : " + id);
		MemberVO mv = dao.selectMem(id);
		int num = mv.getMemberNumber();
		// TODO
		if (id.equals(mv.getMemberId())) {
			if (pw.equals(mv.getMemberPw())) {
				System.out.println("로그인 성공");
				uu = new UserUpdate();
				uu.lblMemberId.setText(mv.getMemberId());
				uu.lblMemberNum.setText(String.valueOf(num));
				uu.setVisible(true);
				dispose();
			} else {
				pane.showMessageDialog(frame, "비밀번호가 틀렸습니다.");
			} // end Pw 체크
		} else {
			pane.showMessageDialog(frame, "아이디가 틀렸습니다.");
		} // end id 체크

	}
}
