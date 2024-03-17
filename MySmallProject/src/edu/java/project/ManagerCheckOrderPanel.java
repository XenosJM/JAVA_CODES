package edu.java.project;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManagerCheckOrderPanel extends JPanel {
	private ManageDAO dao;
	private JTable table;
	private Object value;
	protected int orderNumber;
	private String[] colNames = { "주문번호", "주문한 회원", "상품", "주문수량", "상품종류"  }; // 테이블 헤더에 들어갈 이름들
	private Object[] records = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체
	private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수
	/**
	 * Create the panel.
	 */
	public ManagerCheckOrderPanel() {
		dao = ManageDAOImple.getInstance();
		setBounds(0, 0, 719, 348);
		setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 22, 718, 326);
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
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 718, 23);
		add(menuBar);
		
		JButton btnRefresh = new JButton("새로 고침");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh();
			}
		});
		menuBar.add(btnRefresh);

	}
	protected void refresh() {
		ArrayList<OrderVO> list = dao.selectOrder();
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			OrderVO ov = list.get(i);
			records[0] = ov.getOrderNumber();
			records[1] = ov.getOrderMemId();
			records[2] = ov.getOrderProdName();
			records[3] = ov.getOrderProdQty();
			records[4] = ov.getOrderProdKind();
			tableModel.addRow(records);
		}
		
	}
}
