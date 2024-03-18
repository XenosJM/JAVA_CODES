package edu.java.project;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductManage extends JDialog {

	private ManageDAO dao;
	private String[] colNames = { "상품번호", "상품이름", "상품종류", "상품정보", "상품가격", "상품수량" };
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel;
	private JTable prodManageTable;
	protected JTextField textSearchKeyword;
	private Component currentComponent;
	private Object value;
	protected String keyword;

	public ProductManage() {
		dao = ManageDAOImple.getInstance();
		setBounds(100, 100, 776, 416);
		getContentPane().setLayout(null);

		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 344, 760, 33);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane);

		JPanel buttonPane_1 = new JPanel();
		buttonPane_1.setBounds(0, 0, 760, 33);
		getContentPane().add(buttonPane_1);
		buttonPane_1.setLayout(new FlowLayout(FlowLayout.LEFT));

		JButton okButton = new JButton("확인");
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

		okButton.setActionCommand("확인");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 32, 760, 313);
		getContentPane().add(scrollPane);

		JButton btnSelectProdAll = new JButton("전체 상품목록");
		btnSelectProdAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectProductAll();
			}
		});
		buttonPane_1.add(btnSelectProdAll);

		JButton btnProdFood = new JButton("음식");
		btnProdFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectProductFood();
			}
		});
		buttonPane_1.add(btnProdFood);

		JButton btnProdDrink = new JButton("음료");
		btnProdDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectProductDrink();
			}
		});
		buttonPane_1.add(btnProdDrink);

		JButton btnProdSnack = new JButton("간식");
		btnProdSnack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectProductSnack();
			}
		});
		buttonPane_1.add(btnProdSnack);

		JButton btnProdTime = new JButton("요금제");
		btnProdTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectProductTime();
			}
		});
		buttonPane_1.add(btnProdTime);

		textSearchKeyword = new JTextField();
		textSearchKeyword.setColumns(10);
		buttonPane_1.add(textSearchKeyword);

		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 검색기능 상품테이블에서의 검색만 처리
				System.out.println(textSearchKeyword.getText());
				keyword = textSearchKeyword.getText();
				System.out.println(keyword);
				selectSearchByText(textSearchKeyword.getText());
			}
		});
		buttonPane_1.add(btnSearch);

		JButton btnAddProd = new JButton("상품추가");
		btnAddProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductInsertManage pim = new ProductInsertManage();
				pim.setVisible(true);
			}
		});
		buttonPane_1.add(btnAddProd);
		
//		JButton btnDeleteProd = new JButton("상품삭제");
//		btnDeleteProd.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// TODO
//			}
//		});
//		buttonPane_1.add(btnDeleteProd);

		tableModel = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int colmn) {
				return false;
			}
		};
		prodManageTable = new JTable(tableModel);

		prodManageTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = prodManageTable.getSelectedRow();
				int col = prodManageTable.getSelectedColumn();
				Object value = prodManageTable.getValueAt(row, col);
				System.out.println(value);
				getTextValue(value);

			}
		});
		prodManageTable.setFont(new Font("바탕", Font.PLAIN, 15));
		scrollPane.setViewportView(prodManageTable);
	} // end ProductManage()

	protected void selectSearchByText(String keyword) {
		System.out.println(keyword);
		ArrayList<ProductVO> list = dao.selectSearchByText(keyword);
		ProductVO pv = null;
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			pv = list.get(i);
			records[0] = pv.getProdNumber();
			records[1] = pv.getProdName();
			records[2] = pv.getProdKind();
			records[3] = pv.getProdInfo();
			records[4] = pv.getProdSellPrice();
			records[5] = pv.getProdQty();
			tableModel.addRow(records);
		}

	}

	private void selectProductAll() {
		ProductVO pv = null;
		ArrayList<ProductVO> list = dao.selectProd();
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			pv = list.get(i);
			records[0] = pv.getProdNumber();
			records[1] = pv.getProdName();
			records[2] = pv.getProdKind();
			records[3] = pv.getProdInfo();
			records[4] = pv.getProdSellPrice();
			records[5] = pv.getProdQty();
			tableModel.addRow(records);
		}
	}

	private void selectProductFood() {
		ArrayList<ProductVO> list = dao.selectProdKind("음식");
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			ProductVO pv = list.get(i);
			records[0] = pv.getProdNumber();
			records[1] = pv.getProdName();
			records[2] = pv.getProdKind();
			records[3] = pv.getProdInfo();
			records[4] = pv.getProdSellPrice();
			records[5] = pv.getProdQty();
			tableModel.addRow(records);
		}
	}

	private void selectProductDrink() {
		ArrayList<ProductVO> list = dao.selectProdKind("음료");
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			ProductVO pv = list.get(i);
			records[0] = pv.getProdNumber();
			records[1] = pv.getProdName();
			records[2] = pv.getProdKind();
			records[3] = pv.getProdInfo();
			records[4] = pv.getProdSellPrice();
			records[5] = pv.getProdQty();
			tableModel.addRow(records);
		}
	}

	private void selectProductSnack() {
		ArrayList<ProductVO> list = dao.selectProdKind("간식");
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			ProductVO pv = list.get(i);
			records[0] = pv.getProdNumber();
			records[1] = pv.getProdName();
			records[2] = pv.getProdKind();
			records[3] = pv.getProdInfo();
			records[4] = pv.getProdSellPrice();
			records[5] = pv.getProdQty();
			tableModel.addRow(records);
		}
	}

	private void selectProductTime() {
		ArrayList<ProductVO> list = dao.selectProdKind("요금제");
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			ProductVO pv = list.get(i);
			records[0] = pv.getProdNumber();
			records[1] = pv.getProdName();
			records[2] = pv.getProdKind();
			records[3] = pv.getProdInfo();
			records[4] = pv.getProdSellPrice();
			records[5] = pv.getProdQty();
			tableModel.addRow(records);
		}
	}

	protected void getTextValue(Object value) {
		this.value = value;
	}
}// end ProductManage class
