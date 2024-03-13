package edu.java.project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerLogin extends JFrame {

	private JPanel contentPane;


	public ManagerLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProdManage = new JButton("재고관리");
		btnProdManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				ProductManage prodMg = new ProductManage();
				prodMg.setVisible(true);
			}
		});
		btnProdManage.setBounds(12, 10, 137, 38);
		contentPane.add(btnProdManage);
		
		JButton btnSelectMember = new JButton("전체 회원 조회");
		btnSelectMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		btnSelectMember.setBounds(12, 154, 137, 38);
		contentPane.add(btnSelectMember);
		
		JButton btnSelectMemBy = new JButton("회원검색");
		btnSelectMemBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		btnSelectMemBy.setBounds(12, 202, 137, 38);
		contentPane.add(btnSelectMemBy);
		
		JButton btnUpdateMember = new JButton("회원 정보 변경");
		btnUpdateMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		btnUpdateMember.setBounds(12, 106, 137, 38);
		contentPane.add(btnUpdateMember);
		
		JButton btnInsertMem = new JButton("회원 추가");
		btnInsertMem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		btnInsertMem.setBounds(12, 58, 137, 38);
		contentPane.add(btnInsertMem);
		
		JButton btnManagerLogout = new JButton("로그아웃");
		btnManagerLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProjectMain projectMain = new ProjectMain();
				projectMain.frame.setVisible(true);
			}
		});
		btnManagerLogout.setBounds(12, 250, 137, 38);
		contentPane.add(btnManagerLogout);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(12, 298, 137, 38);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setBounds(12, 346, 137, 38);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(284, 15, 129, 129);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(566, 15, 129, 129);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(425, 15, 129, 129);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(707, 10, 129, 129);
		contentPane.add(lblNewLabel_3);
	}
}
