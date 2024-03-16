package edu.java.project;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageAllSelectMember extends JPanel {

	private static ManageDAO dao;
	private JOptionPane pane;
	private JFrame frame;
	private JTable table;
	private Object value;
	private String[] colNames = { "회원번호", "아이디", "이름", "전화번호", "이메일", "시간", "관리자여부" }; // 테이블 헤더에 들어갈 이름들
	private Object[] records = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체
	private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수

	/**
	 * Create the panel.
	 */
	public ManageAllSelectMember() {
		dao = ManageDAOImple.getInstance();

		setBounds(0, 0, 862, 641);
		setLayout(null);

		JButton btnSelectMemBy = new JButton("회원검색");
		btnSelectMemBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MemberVO mv = dao.selectMem((String) value);
					if (mv != null && mv.getMemberId().equals((String) value)) {						
						pane.showMessageDialog(btnSelectMemBy, dao.selectMem((String) value));	
					}
				} catch (Exception e2) {
					// TODO: handle exception
					pane.showMessageDialog(btnSelectMemBy, "검색을 원하시는 아이디를 선택하고 검색버튼을 누르세요.");
				}
				
			}
		});
		btnSelectMemBy.setBounds(12, 10, 133, 23);
		add(btnSelectMemBy);

		JButton btnUpdateMember = new JButton("회원 정보 변경");
		btnUpdateMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 관리자 멤버 업데이트 창 띄우게 하고 기능 정리
			}
		});
		btnUpdateMember.setBounds(157, 10, 150, 23);
		add(btnUpdateMember);

		JButton btnSearchHist = new JButton("기록검색");
		btnSearchHist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 기록 검색을 날짜 스피너와 시간 스피너를 이용해서 히스토리별로 정리
			}
		});
		btnSearchHist.setBounds(319, 10, 116, 23);
		add(btnSearchHist);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 43, 862, 349);
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
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 444, 862, 197);
		add(scrollPane_1);
		selectAllMemberInfo();
	}

	protected void getTextValue(Object value) {
		this.value = value;

	}

	private void selectAllMemberInfo() {
		ArrayList<MemberVO> list = dao.selectMem();
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			MemberVO mv = list.get(i);
			records[0] = mv.getMemberNumber();
			records[1] = mv.getMemberId();
			records[2] = mv.getMemberName();
			records[3] = mv.getMemberPhone();
			records[4] = mv.getMemberEmail();
			records[5] = mv.getMemberTime();
			records[6] = mv.getMemberManager();
			tableModel.addRow(records);
		}
	} // end selectAllContactTable()
}
