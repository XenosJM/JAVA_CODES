package edu.java.project;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AllHistoryPanel extends JPanel {

	private String[] colNames = { "상품이름", "상품종류", "상품정보", "상품가격" };
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public AllHistoryPanel() {
		setBounds(100, 100, 922, 536);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 922, 536);
		add(scrollPane);

		tableModel = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(tableModel);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				Object value = table.getValueAt(row, col);
//				System.out.println(value);
				getTextValue(value);
//				ProductVO pv = dao.selectProd((String) value);
//				int spinProdQty = (int) spinnerChoiceProdQty.getValue();
//				int sum = pv.getProdSellPrice() * spinProdQty;
//				System.out.println(sum);
//				String strSum = String.valueOf(sum);
//				System.out.println(strSum);
//				lblSumPrice.setText("계산하실 금액 : " + strSum);
//				try {
//					lblChoiceProdName.setText((String) value);
//
//				} catch (Exception e2) {
//					pane.showMessageDialog(scrollPane, "상품명을 클릭하고 구매버튼을 눌러주세요.");
//				}
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
	}

	protected void getTextValue(Object value) {
		// TODO Auto-generated method stub
		
	}

}
