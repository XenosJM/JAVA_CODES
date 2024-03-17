package edu.java.project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderHist extends JFrame {

	private ManageDAO dao;
	private JLabel lblOrderNotice;
	private final JPanel contentPanel = new JPanel();
	protected JFrame frame;
	private JOptionPane pane;
	protected JButton okButton, cancelButton;
	protected JLabel lblOrderNumber, lblOrderName, lblOrderQty,
	lblShowOrderNumber, lblShowOrderName, lblShowOrderQty, lblOrderMemId, lblOrderMemNum, lblShowOrderKind;
	
	public OrderHist() {
		dao = ManageDAOImple.getInstance();

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);

		lblOrderNotice = new JLabel("마지막 주문 내역");
		lblOrderNotice.setBounds(112, 9, 97, 23);
		getContentPane().add(lblOrderNotice);

		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 228, 434, 33);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane);

		cancelButton = new JButton("주문 취소");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 주문 취소를 위해서는 주문 번호값이 필요하고 아무 주문이나 마지막걸 취소 할수없으니까
				// 주문을 한 사람의 마지막 주문을 보여주고 취소(삭제) 시킨다.
				int showOrderNum = Integer.valueOf(lblShowOrderNumber.getText());
				orderCancel(showOrderNum);
				pane.showMessageDialog(buttonPane, "주문을 취소합니다.");
				dispose();
				
			}
		});
		
				okButton = new JButton("확인");
				buttonPane.add(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		lblOrderNumber = new JLabel("주문 번호");
		lblOrderNumber.setBounds(65, 49, 104, 33);
		getContentPane().add(lblOrderNumber);
		
		lblOrderName = new JLabel("상품 이름");
		lblOrderName.setBounds(65, 135, 104, 33);
		getContentPane().add(lblOrderName);
		
		lblOrderQty = new JLabel("상품 개수");
		lblOrderQty.setBounds(65, 175, 104, 33);
		getContentPane().add(lblOrderQty);
		
		lblShowOrderNumber = new JLabel("표시할 주문 번호");
		lblShowOrderNumber.setBounds(181, 49, 104, 33);
		getContentPane().add(lblShowOrderNumber);
		
		lblShowOrderName = new JLabel("표시할 상품 이름");
		lblShowOrderName.setBounds(181, 135, 104, 33);
		getContentPane().add(lblShowOrderName);
		
		lblShowOrderQty = new JLabel("표시할 상품 개수");
		lblShowOrderQty.setBounds(181, 178, 104, 33);
		getContentPane().add(lblShowOrderQty);
		
		lblOrderMemId = new JLabel("주문한 회원아이디");
		lblOrderMemId.setBounds(310, 41, 124, 40);
		getContentPane().add(lblOrderMemId);
		
		lblOrderMemNum = new JLabel("주문한 회원번호");
		lblOrderMemNum.setBounds(310, 0, 124, 40);
		getContentPane().add(lblOrderMemNum);
		
		JLabel lblOrderKind = new JLabel("상품 종류");
		lblOrderKind.setBounds(65, 92, 104, 33);
		getContentPane().add(lblOrderKind);
		
		lblShowOrderKind = new JLabel("표시할 상품 종류");
		lblShowOrderKind.setBounds(181, 92, 104, 33);
		getContentPane().add(lblShowOrderKind);

	}

	protected void orderCancel(int orderNumber) {
		
		dao.orderCancel(orderNumber);
	}
}
