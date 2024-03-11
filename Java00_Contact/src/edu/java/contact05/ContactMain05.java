package edu.java.contact05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Canvas;
import javax.swing.JPanel;

public class ContactMain05 {

	private JFrame frame;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textIndex;
	public static ContactDAO dao;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dao = ContactDAOImple.getInstance();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain05 window = new ContactMain05();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); // end Thread
	}

	 
	public ContactMain05() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 677);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("연락처 프로그램 Version 0.5");
		lblNewLabel.setBounds(12, 10, 665, 58);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("궁서체", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(12, 78, 120, 58);
		lblName.setFont(new Font("궁서체", Font.PLAIN, 30));
		frame.getContentPane().add(lblName);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setBounds(12, 144, 120, 58);
		lblPhone.setFont(new Font("궁서체", Font.PLAIN, 30));
		frame.getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(12, 212, 120, 58);
		lblEmail.setFont(new Font("궁서체", Font.PLAIN, 30));
		frame.getContentPane().add(lblEmail);
		
		textName = new JTextField();
		textName.setBounds(144, 78, 199, 58);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setBounds(144, 144, 199, 58);
		textPhone.setColumns(10);
		frame.getContentPane().add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setBounds(144, 212, 199, 58);
		textEmail.setColumns(10);
		frame.getContentPane().add(textEmail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 416, 404, 104);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textAreaInfo = new JTextArea();		
		scrollPane.setViewportView(textAreaInfo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 529, 404, 99);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea textAreaLog = new JTextArea();
		scrollPane_1.setViewportView(textAreaLog);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(428, 348, 224, 280);
		frame.getContentPane().add(scrollPane_2);
		
		JTextArea textAreaTable = new JTextArea();
		textAreaTable.setBounds(428, 78, 199, 104);
		frame.getContentPane().add(textAreaTable);

		
		String[] header = {"번호", "이름", "전화번호", "이메일"};	
		// 행에 들어갈 배열
		ArrayList<ContactVO> list = (ArrayList<ContactVO>) dao.select();
		String[][] data = new String[list.size()][1000];
        for (int i = 0; i < list.size(); i++) {
            ContactVO contact = list.get(i);
            data[i] = contact.toStringArray();
        }
        // 열에 들어갈 배열 인덱스 번호를 갖고 와야한다.
		table = new JTable(data, header);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				textAreaTable.setText(table.toString());
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				Object Value = table.getValueAt(row, col);
				textAreaTable.setText(Value.toString());
			}
		});
		scrollPane_2.setViewportView(table);
		// TODO 현재 문제점 프로그램 시작시 한번만 불러온다.
		// 전체검색 누를때마다 불러오도록 바꿔야함.
		
		JButton btnInsert = new JButton("등록");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textName.getText();
				String phone = textPhone.getText();
				String email = textEmail.getText();
				ContactVO vo = new ContactVO(name, phone, email);
				
				int result = dao.insert(vo);
				int size = ((ContactDAOImple) dao).getSize();
				String insertlog = "등록된 연락처 개수 : " + size + "\n"
						+ "연락처 등록 완료!" + "\n";
				textAreaInfo.setText("입력한 연락처 정보" + "\n" + vo.toString());
				if(result == 1) {
					textAreaLog.setText(insertlog);					
				}
					textAreaInfo.getText();					
			}
		});
		btnInsert.setBounds(12, 280, 120, 58);
		btnInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		frame.getContentPane().add(btnInsert);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("---------------");
				System.out.println("검색할 인덱스 입력>");
				try {
					int index = Integer.parseInt(textIndex.getText());				
					int size = ((ContactDAOImple) dao).getSize();
//					ContactVO vo = (dao.select(index));
					if(index >= 0 && index < size) {
						System.out.println(dao.select(index));					
//			textAreaInfo.setText(vo.toString()); 내가 적은 코드 : toString을 쓰는건 알았는데, 
						// 괄호 넣는걸 생각 못해서 변수선언을 한번 더 하고 toString을 사용했다.
						// 비효울적
						textAreaInfo.setText(dao.select(index).toString());
					} else {
						System.out.println("해당 인덱스에 연락처가 없습니다.");
						textAreaLog.setText("해당 인덱스에 연락처가 없습니다.");
					}
				} catch (NumberFormatException E) {
					textAreaInfo.setText("숫자를 입력하세요");
				}
			}
		});
		btnSearch.setBounds(276, 280, 120, 58);
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		frame.getContentPane().add(btnSearch);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("수정할 인덱스 입력>");
				int index = Integer.parseInt(textIndex.getText());				
				int size = ((ContactDAOImple) dao).getSize();
				
				if(index >= 0 && index < size) {
					
					String name = textName.getText();
					String phone = textPhone.getText();
					String email = textEmail.getText();
					
					ContactVO vo = new ContactVO(name, phone, email);								
					int result = dao.update(index, vo);
					String updatelog = "등록된 연락처 개수 : " + size + "\n" +
					"연락처 수정 완료!" + "\n";
					textAreaInfo.setText("수정한 연락처 정보" + "\n" + vo.toString());
					if(result == 1) {
						System.out.println("연락처 수정 완료!");						
						textAreaLog.setText(updatelog);					
					}
				} else {
					System.out.println("해당 인덱스에 연락처가 없습니다.");
					textAreaLog.setText("해당 인덱스에 연락처가 없습니다.");
				} // end if- else				
			} // end actionPerformed
		}); // end listener
		btnUpdate.setBounds(12, 348, 120, 58);
		btnUpdate.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("삭제할 인덱스 입력>");
				int index = Integer.parseInt(textIndex.getText());
				
				int size = ((ContactDAOImple) dao).getSize();
				if(index >= 0 && index < size) {
					int result = dao.delete(index);					
					if(result == 1) {
						System.out.println("연락처 삭제 완료");
						textAreaLog.setText("연락처 삭제 완료");
					}
				} else {
					System.out.println("해당 인덱스에 연락처가 없습니다.");
					textAreaLog.setText("해당 인덱스에 연락처가 없습니다.");
				}
				System.out.println("연락처 삭제 작동 종료");
			}
		});
		btnDelete.setBounds(144, 348, 120, 58);
		btnDelete.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		frame.getContentPane().add(btnDelete);
		
		JButton btnAllSearch = new JButton("전체검색");
		btnAllSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ContactVO> list = (ArrayList<ContactVO>) dao.select();				
				int size = ((ContactDAOImple) dao).getSize();
				for(int i = 0; i < size; i++) {
					String result = "연락처 개수 : " + size + "\n"
							+ "--- 연락처 " + i + " ---" + "\n"
							+ list.get(i).toString() + "\n";								
					textAreaInfo.append(result); 
				}
			}
		});
		btnAllSearch.setBounds(276, 348, 140, 58);
		btnAllSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		frame.getContentPane().add(btnAllSearch);
		
		textIndex = new JTextField();
		// TODO 마우스를 가져다 대면 글자가 사라지게.
		textIndex.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
		textIndex.setHorizontalAlignment(SwingConstants.CENTER);
		textIndex.setText("번호입력");
		textIndex.setBounds(144, 280, 120, 58);
		frame.getContentPane().add(textIndex);
		textIndex.setColumns(10);
		

		/* 1. 정보를 입력하고 등록버튼을 클릭하면 정보가 파일에 저장된다.
		 * 2. 인덱스 번호를 입력하고 검색 번호를 누르면
		 * 	  파일에 저장된 하나의 데이터가 출력한다.
		 * 3. 인덱스 번호를 입력하고 정보를 입력한 후, 수정버튼을 누르면
		 * 	  파일에 저장된 정보가 수정된다.
		 * 4. 인덱스 번호를 입력하고 삭제버튼을 누르면 파일에 저장된 정보가 삭제된다.
		 * 5. 전체검색을 클릭하면 모든 정보가 출력된다.
		 * 
		 * 추가
		 * 1. 수정버튼을 누르면 전체 데이터를 테이블에 출력한다.
		 * 2. 삭제버튼을 누르면 전체 데이터를 테이블에 출력한다.
		 * 3. 전체검색을 누르면 전체 데이터를 테이블에 출력한다.	  
		 * 
		 *  TODO 기능들 모듈화 해서 밑에 메소드화 해서 빼놓고 실행해보기
		 */  
		/*  private String[] colNames =
		 *  private Object[] records = new Object[colums.
		 *  mode.addRow(data); 
		 */

//		private void selectAllContactTable() {
//			ArrayList<ContactVO> list = dao.select();
//			tableModel.setRowCount(0);
//			for(int i = 0; i < list.size(); i++) {
//				ContactVO vo = list.get(i);
//				records[0] = i;
//				records[1] = vo.getName();
//				records[2] = vo.getPhone();
//				records[3] = vo.getEmail();
//				tableModel.addRow(records);
//			} 
//		} // end selectAllContactTable() 테이블 데이터 입력 코드
		
		
	}// end main
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
} // end ContactMainWithGui
