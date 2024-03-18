package edu.java.project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

public class UserTimeCharge extends JFrame {

	private JPanel contentPane;
	private ManageDAO dao;
	protected JLabel lblUtcMemberId, lblUtcMemberNumber;
	protected int lastTime, addTime, sumTime, hour;
	protected JButton btnOneHour, btnThreeHour, btnFiveHour, btnTenHour, btnTwentyHour;
	protected Timer timer;
	/**
	 * Create the frame.
	 */
	public UserTimeCharge() {
		dao = ManageDAOImple.getInstance();
		setBounds(100, 100, 329, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnOneHour = new JButton("1시간 요금제");
		btnOneHour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MemberLogin login = new MemberLogin();
				int oneHour = 3600;
				login.utchour = oneHour;
				dispose();
			}
		});
		btnOneHour.setBounds(12, 61, 188, 48);
		contentPane.add(btnOneHour);
		
		JLabel lblProdTime = new JLabel("요금제 목록");
		lblProdTime.setBounds(12, 10, 73, 41);
		contentPane.add(lblProdTime);
		
		btnThreeHour = new JButton("3시간 요금제");
		btnThreeHour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int threeHour = 10800;
				MemberLogin login = new MemberLogin();
				login.lblMemberId.setText(lblUtcMemberId.getText());
//				timer = login.timer;
//				login.timer.cancel();
//				login.addTime(threeHour);
				login.currentTime();
			}
		});
		btnThreeHour.setBounds(12, 119, 188, 48);
		contentPane.add(btnThreeHour);
		
		btnFiveHour = new JButton("5시간 요금제");
		btnFiveHour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fiveHour = 18000;
				MemberLogin login = new MemberLogin();
				login.lblMemberId.setText(lblUtcMemberId.getText());
//				timer = login.timer;
//				login.timer.cancel();
//				login.addTime(fiveHour);
				login.currentTime();
			}
		});
		btnFiveHour.setBounds(12, 177, 188, 48);
		contentPane.add(btnFiveHour);
		
		btnTenHour = new JButton("10시간 요금제");
		btnTenHour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int tenHour = 36000;
				MemberLogin login = new MemberLogin();
				login.lblMemberId.setText(lblUtcMemberId.getText());
//				timer = login.timer;
//				login.timer.cancel();
//				login.addTime(tenHour);
				login.currentTime();
			}
		});
		btnTenHour.setBounds(12, 235, 188, 48);
		contentPane.add(btnTenHour);
		
		btnTwentyHour = new JButton("20시간 요금제");
		btnTwentyHour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int twentyHour = 72000;
				MemberLogin login = new MemberLogin();
				login.lblMemberId.setText(lblUtcMemberId.getText());
//				timer = login.timer;
//				login.timer.cancel();
//				login.addTime(twentyHour);
				login.currentTime();
			}
		});
		btnTwentyHour.setBounds(12, 293, 188, 48);
		contentPane.add(btnTwentyHour);
		
		lblUtcMemberId = new JLabel("회원 아이디");
		lblUtcMemberId.setBounds(161, 10, 148, 41);
		contentPane.add(lblUtcMemberId);
		
		lblUtcMemberNumber = new JLabel("회원 번호");
		lblUtcMemberNumber.setBounds(97, 10, 52, 41);
		contentPane.add(lblUtcMemberNumber);
		
		JButton btnNewButton = new JButton("취소");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(212, 332, 97, 23);
		contentPane.add(btnNewButton);
		
		
	} // end UserTimeCharge()


}
