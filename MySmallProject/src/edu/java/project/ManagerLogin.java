package edu.java.project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextArea;

public class ManagerLogin extends JFrame {
	private JPanel contentPane, PCManagePanel, ProdManagePanel;
	private JTextPane textPaneNotice;
	private Component currentComponent;
	private ManageDAO dao;

	public ManagerLogin() {
		dao = ManageDAOImple.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 705);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JButton btnPCManage = new JButton("PC관리");
		btnPCManage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// 현재 판넬 제거
				getContentPane().remove(currentComponent);
				revalidate(); // 컴퍼넌트 재검토
				repaint(); // 컴퍼넌트 다시 그림
				textPaneNotice.setVisible(false);
				// 로그인 했을 때 보여줄 판넬 추가
				PCManagePanel PC = new PCManagePanel();

				// 로그인 판넬을 프레임에 연결
				getContentPane().add(PC, BorderLayout.CENTER);
				revalidate();
				repaint();

				currentComponent = PC;

			}
		});
		menuBar.add(btnPCManage);

		JButton btnSelectMember = new JButton("전체 회원 조회");
		menuBar.add(btnSelectMember);
		btnSelectMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 현재 판넬 제거
				getContentPane().remove(currentComponent);
				revalidate(); // 컴퍼넌트 재검토
				repaint(); // 컴퍼넌트 다시 그림
				// 로그인 했을 때 보여줄 판넬 추가
				ManageAllSelectMember mas= new ManageAllSelectMember();
				// 로그인 판넬을 프레임에 연결
				getContentPane().add(mas, BorderLayout.CENTER);
				revalidate();
				repaint();
				textPaneNotice.setVisible(false);
				

				currentComponent = mas;
			}
			
		});

//		JButton btnTimeCharge = new JButton("회원 시간 충전");
//		btnTimeCharge.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				UserTimeCharge utc = new UserTimeCharge();
//				utc.setVisible(true);
//				}
//		});
//		menuBar.add(btnTimeCharge);
		
		JButton btnCheckOrder = new JButton("주문확인");
		btnCheckOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				// 현재 판넬 제거
				getContentPane().remove(currentComponent);
				revalidate(); // 컴퍼넌트 재검토
				repaint(); // 컴퍼넌트 다시 그림
				textPaneNotice.setVisible(false);
				// 로그인 했을 때 보여줄 판넬 추가
				ManagerCheckOrderPanel mco = new ManagerCheckOrderPanel();

				// 로그인 판넬을 프레임에 연결
				getContentPane().add(mco, BorderLayout.CENTER);
				revalidate();
				repaint();

				currentComponent = mco;
			}
		});
		menuBar.add(btnCheckOrder);

		JButton btnProdManage = new JButton("재고관리");
		menuBar.add(btnProdManage);
		btnProdManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				ProductManage prodMg = new ProductManage();
//				System.out.println("주시중");
				prodMg.keyword = prodMg.textSearchKeyword.getText();;
				prodMg.setVisible(true);
			}
		});
		
		JButton btnSearchHist = new JButton("기록 검색");
		btnSearchHist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AllHistorySearch ahs = new AllHistorySearch();
				ahs.setVisible(true);
				
			}
		});
		menuBar.add(btnSearchHist);

		JButton btnManagerLogout = new JButton("로그아웃");
		menuBar.add(btnManagerLogout);
		btnManagerLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProjectMain projectMain = new ProjectMain();
				projectMain.frame.setVisible(true);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		currentComponent = contentPane;

		textPaneNotice = new JTextPane();
		textPaneNotice.setFont(new Font("굴림", Font.PLAIN, 45));
		textPaneNotice.setFocusable(false);
		textPaneNotice.setText("관리할 목록을 골라 주세요.");
		textPaneNotice.setBounds(147, 268, 570, 72);
		contentPane.add(textPaneNotice);
		

	}
}
