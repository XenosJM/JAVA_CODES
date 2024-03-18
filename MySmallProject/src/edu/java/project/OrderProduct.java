package edu.java.project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

public class OrderProduct extends JDialog {
	private ManageDAO dao;
	private final JPanel contentPanel = new JPanel(), buttonPane;
	protected JFrame frame;
	private JOptionPane pane;
	protected JButton okButton, cancelButton;
	private String[] colNames = {"상품이름", "상품종류", "상품정보", "상품가격"};
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel;
	private JTable tableAllProd;
	private Object value;
	protected JLabel lblChoiceProdName, lblSumPrice, lblOrderMember;
	private String keyword;
	private JSpinner spinnerChoiceProdQty;
	private JTextField textSearchKeyword;
	
	/**
	 * Create the dialog.
	 */
	public OrderProduct() {
		dao = ManageDAOImple.getInstance();
		setBounds(100, 100, 964, 391);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 948, 249);
		contentPanel.add(scrollPane);

		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("주문");
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// 이름으로 검색한 결과값이 누른 밸류값과 다르면 떠야한다.
					ProductVO pv = dao.selectProd((String) value);
//					System.out.println(pv);
//					System.out.println(value);
					if (pv.getProdName() == null) {						
						pane.showMessageDialog(scrollPane, "상품명을 클릭하고 구매버튼을 눌러주세요.");	
						if(pv.getProdName().equals((int)value)) {
							pane.showMessageDialog(scrollPane, "상품명을 클릭하고 구매버튼을 눌러주세요.");
						}
					}
					// 처리를 할때 pv에서 업데이트 시키냐 새로 인서트 시키냐 의 차이에서 아무래도 새 주문이 들어가니까
					// 인서트 처리가 맞다.
					String memberId = lblOrderMember.getText();
					String prodName = pv.getProdName();
					int spinProdQty = (int) spinnerChoiceProdQty.getValue();
					String prodKind = pv.getProdKind();
					OrderVO ov = new OrderVO(0, memberId, prodName, prodKind, spinProdQty);
					dao.insertOrder(ov);

					int prodNumber = pv.getProdNumber();
					int prodQty = pv.getProdQty();
					ProductVO upv = new ProductVO(prodNumber, "0", "0", "0", 0, prodQty-spinProdQty);				
					dao.updateProdUser(prodNumber, upv); // TODO 팔린만큼 감소 처리 할것, 임시방편으로 잊지않기위해 짠 코드
					dispose();
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					pane.showMessageDialog(scrollPane, "상품명을 클릭하고 구매버튼을 눌러주세요.");
				}
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		cancelButton = new JButton("취소");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPane.add(cancelButton);
		
		tableModel = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableAllProd = new JTable(tableModel);

		tableAllProd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				int row = tableAllProd.getSelectedRow();
				int col = tableAllProd.getSelectedColumn();
				Object value = tableAllProd.getValueAt(row, col);
//				System.out.println(value);
				getTextValue(value);				
				ProductVO pv = dao.selectProd((String) value);
				int spinProdQty = (int) spinnerChoiceProdQty.getValue();
				int sum = pv.getProdSellPrice() * spinProdQty;
//				System.out.println(sum);
				String strSum = String.valueOf(sum);
//				System.out.println(strSum);
				lblSumPrice.setText("계산하실 금액 : " + strSum);
				
					lblChoiceProdName.setText((String) value);
					
				} catch (Exception e2) {
					pane.showMessageDialog(scrollPane, "상품명을 클릭하고 구매버튼을 눌러주세요.");
				}
			}
		});
		
		tableAllProd.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane.setViewportView(tableAllProd);
		
		lblChoiceProdName = new JLabel("선택한 상품 이름");
		
		lblChoiceProdName.setBounds(93, 259, 104, 22);
		contentPanel.add(lblChoiceProdName);
		
		SpinnerModel model = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		spinnerChoiceProdQty = new JSpinner(model);		
		spinnerChoiceProdQty.setBounds(209, 259, 50, 21);
		contentPanel.add(spinnerChoiceProdQty);
		
		lblSumPrice = new JLabel("선택한 상품 총 가격");
		lblSumPrice.setBounds(271, 259, 149, 22);
		contentPanel.add(lblSumPrice);
		
		JLabel lblProdNotice = new JLabel("상품을 구매하시려면 상품 이름을 클릭 하시고 수량을 정하신뒤 주문 버튼을 눌러주세요.");
		lblProdNotice.setBounds(432, 259, 504, 22);
		contentPanel.add(lblProdNotice);
		
		lblOrderMember = new JLabel("주문하는 회원");
		lblOrderMember.setBounds(0, 259, 81, 21);
		contentPanel.add(lblOrderMember);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnListAll = new JButton("전체 목록");
		btnListAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectProductAll();
			}
		});
		menuBar.add(btnListAll);
		
		JButton btnFoodList = new JButton("음식");
		btnFoodList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectProductFood();
			}
		});
		menuBar.add(btnFoodList);
		
		JButton btnDrinkList = new JButton("음료");
		btnDrinkList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectProductDrink();
			}
		});
		menuBar.add(btnDrinkList);
		
		JButton btnSnackList = new JButton("간식");
		btnSnackList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectProductSnack();
			}
		});
		menuBar.add(btnSnackList);
		
		JButton btnTimeList = new JButton("요금제");
		btnTimeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectProductTime();
			}
		});
		menuBar.add(btnTimeList);
		
		textSearchKeyword = new JTextField();
		textSearchKeyword.setColumns(10);
		menuBar.add(textSearchKeyword);
		
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
		menuBar.add(btnSearch);

 /*
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            // Enter 키가 눌렸을 때 실행할 동작을 여기에 추가하세요
		        	// 테이블 목록중 일치하는 것만 보여주는 코드를 하고 싶지만 실력에 비해 너무 과함 어떻게 해야할지 모름
		        }
		    }
		});
		menuBar.add(textField);
		textField.setColumns(10);
  */		
		
	} // end OrderProduct()


	protected void selectSearchByText(String text) {
		System.out.println(keyword);
		ArrayList<ProductVO> list = dao.selectSearchByText(keyword);
		ProductVO pv = null;
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			pv = list.get(i);
			records[0] = pv.getProdName();
			records[1] = pv.getProdKind();
			records[2] = pv.getProdInfo();
			records[3] = pv.getProdSellPrice();
			tableModel.addRow(records);
		}
	}


	private void selectProductAll() {
		ProductVO pv = null;
		ArrayList<ProductVO> list = dao.selectProd();		
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			pv = list.get(i);
			records[0] = pv.getProdName();
			records[1] = pv.getProdKind();
			records[2] = pv.getProdInfo();
			records[3] = pv.getProdSellPrice();
			tableModel.addRow(records);
		}
	}
	
	private void selectProductFood() {
		ArrayList<ProductVO> list = dao.selectProdKind("음식");
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			ProductVO pv = list.get(i);
			records[0] = pv.getProdName();
			records[1] = pv.getProdKind();
			records[2] = pv.getProdInfo();
			records[3] = pv.getProdSellPrice();
			tableModel.addRow(records);
		}
	}

	private void selectProductDrink() {
		ArrayList<ProductVO> list = dao.selectProdKind("음료");
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			ProductVO pv = list.get(i);
			records[0] = pv.getProdName();
			records[1] = pv.getProdKind();
			records[2] = pv.getProdInfo();
			records[3] = pv.getProdSellPrice();
			tableModel.addRow(records);
		}
	}
	
	private void selectProductSnack() {
		ArrayList<ProductVO> list = dao.selectProdKind("간식");
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			ProductVO pv = list.get(i);
			records[0] = pv.getProdName();
			records[1] = pv.getProdKind();
			records[2] = pv.getProdInfo();
			records[3] = pv.getProdSellPrice();
			tableModel.addRow(records);
		}
	}
	
	private void selectProductTime() {
		ArrayList<ProductVO> list = dao.selectProdKind("요금제");
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			ProductVO pv = list.get(i);
			records[0] = pv.getProdName();
			records[1] = pv.getProdKind();
			records[2] = pv.getProdInfo();
			records[3] = pv.getProdSellPrice();
			tableModel.addRow(records);
		}
	}
	


	protected void getTextValue(Object value) {
		this.value = value;
	}

}
