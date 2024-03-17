package edu.java.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class ProductInsertManage extends JFrame {
	
	private ManageDAO dao;
	private JPanel contentPane;
	private JTextField textFieldProductName, textFieldProductInfo;
	private JSpinner spinnerProductQty, spinnerProductPrice;
	private JComboBox comboBoxProdKind;
	
	/**
	 * Create the frame.
	 */
	public ProductInsertManage() {
		dao = ManageDAOImple.getInstance();
		setBounds(100, 100, 450, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductName = new JLabel("상품 이름");
		lblProductName.setBounds(12, 50, 97, 30);
		getContentPane().add(lblProductName);

		textFieldProductName = new JTextField();
		textFieldProductName.setBounds(124, 51, 147, 30);
		getContentPane().add(textFieldProductName);
		textFieldProductName.setColumns(10);
		

		JLabel lblProductKind = new JLabel("상품 종류");
		lblProductKind.setBounds(12, 90, 97, 30);
		getContentPane().add(lblProductKind);

		JLabel lblProductInfo = new JLabel("상품 정보");
		lblProductInfo.setBounds(12, 129, 97, 30);
		getContentPane().add(lblProductInfo);

		textFieldProductInfo = new JTextField();
		textFieldProductInfo.setBounds(124, 130, 147, 30);
		getContentPane().add(textFieldProductInfo);
		textFieldProductInfo.setColumns(10);

		// 상품 수량 레이블 및 JSpinner 추가
		JLabel lblProductQty = new JLabel("상품 수량:");
		lblProductQty.setBounds(12, 210, 100, 30);
		getContentPane().add(lblProductQty);

		spinnerProductQty = new JSpinner();
		spinnerProductQty.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1)); // 최소값 0, 최대값 없음, 증감값 1로 설정
		spinnerProductQty.setBounds(124, 211, 147, 30);
		getContentPane().add(spinnerProductQty);

		// 상품 가격 레이블 및 JSpinner 추가
		JLabel lblProductPrice = new JLabel("상품 가격:");
		lblProductPrice.setBounds(12, 170, 100, 30);
		getContentPane().add(lblProductPrice);

		spinnerProductPrice = new JSpinner();
		spinnerProductPrice.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 100)); // 최소값 0, 최대값 없음, 증감값 100으로 설정
		spinnerProductPrice.setBounds(124, 171, 147, 30);
		getContentPane().add(spinnerProductPrice);

		JButton btnInsertProduct = new JButton("상품 추가");
		btnInsertProduct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        insertProduct(); 
		        dispose();
		    }
		});
		btnInsertProduct.setBounds(79, 251, 97, 23);
		getContentPane().add(btnInsertProduct);

		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(191, 252, 97, 21);
		getContentPane().add(btnCancel);

		JLabel lblNewProductInsert = new JLabel("새 상품 추가 화면");
		lblNewProductInsert.setBounds(141, 4, 106, 37);
		getContentPane().add(lblNewProductInsert);
		
		comboBoxProdKind = new JComboBox();
		comboBoxProdKind.addItem("음식");
		comboBoxProdKind.addItem("음료");
		comboBoxProdKind.addItem("간식");
		comboBoxProdKind.addItem("요금제");
		comboBoxProdKind.setBounds(124, 91, 147, 30);
		contentPane.add(comboBoxProdKind);
		}

		// 상품 추가 메서드
		private void insertProduct() {
		String productName = textFieldProductName.getText();
		String productKind = (String)comboBoxProdKind.getSelectedItem();
		System.out.println(productKind);
		String productInfo = textFieldProductInfo.getText();
		int productPrice = (int)spinnerProductPrice.getValue();
		int productQuantity = (int)spinnerProductQty.getValue();
		ProductVO pv = new ProductVO(0, productName, productKind, productInfo, productPrice, productQuantity);
		dao.insertProd(pv);

		// 이후 데이터베이스에 추가하는 로직을 작성합니다.
		// 추가된 결과에 따라 적절한 처리를 수행합니다.
	}
}
