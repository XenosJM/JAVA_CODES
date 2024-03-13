package edu.java.project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ProductManage extends JDialog {
	private JPanel contentPanel = new JPanel();
	
	private ManageDAO dao;
	private JTable Prodtable;
	private String[] colNames = {"상품번호", "상품이름", "상품정보", "상품가격", "상품수량"};
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel;
	public ProductManage() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("저장");
				okButton.setActionCommand("저장");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.setActionCommand("취소");
				buttonPane.add(cancelButton);
			}
		}
	}

}
