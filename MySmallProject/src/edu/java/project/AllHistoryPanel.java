package edu.java.project;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AllHistoryPanel extends JPanel {

	private String[] colNames = { "기록번호", "기록날짜", "회원기록", "상품기록", "PC기록", "주문기록" };
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel;
	private ManageDAO dao;
	private JTable table;
	private Object value;
	private JOptionPane pane;

	/**
	 * Create the panel.
	 */
	public AllHistoryPanel() {
		dao = ManageDAOImple.getInstance();
		setBounds(0, 0, 922, 536);
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
				System.out.println(value);
				getTextValue(value);
//			
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		getHistAll();
	}

	private void getHistAll() {
		ArrayList<HistoryVO> list = dao.selectHist();
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			HistoryVO hv = list.get(i);
			records[0] = hv.getHistNumber();
			records[1] = hv.getHistDate();
			records[2] = hv.getHistMem();
			records[3] = hv.getHistProd();
			records[4] = hv.getHistPC();
			records[5] = hv.getHistOrder();
			tableModel.addRow(records);
		}
		
	}

	protected void getTextValue(Object value) {
		this.value = value;
		
	}
	
	
}
