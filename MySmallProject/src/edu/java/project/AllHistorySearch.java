package edu.java.project;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;

public class AllHistorySearch extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Component currentComponent;

	/**
	 * Create the frame.
	 */
	public AllHistorySearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 536);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().remove(currentComponent);
				revalidate(); // 컴퍼넌트 재검토
				repaint(); // 컴퍼넌트 다시 그림

				AllHistoryPanel ahp = new AllHistoryPanel();

				// 로그인 판넬을 프레임에 연결
				getContentPane().add(ahp, BorderLayout.CENTER);
				revalidate();
				repaint();

				currentComponent = ahp;
			}
		});
		menuBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		menuBar.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		menuBar.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		menuBar.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("New button");
		menuBar.add(btnNewButton_4);
		
        Calendar calendar = Calendar.getInstance();
        Date initialDate = calendar.getTime();
        JMenuItem dateMenuItem = new JMenuItem("Select Date");
        JMenuItem timeMenuItem = new JMenuItem("Select Time");
        
		SpinnerDateModel dateModel = new SpinnerDateModel(initialDate, null, null, Calendar.DAY_OF_MONTH);
		JSpinner spinner = new JSpinner(dateModel);
        menuBar.add(spinner);
        
        SpinnerDateModel timeModel = new SpinnerDateModel(initialDate, null, null, Calendar.HOUR_OF_DAY);
		JSpinner spinner_1 = new JSpinner(timeModel);
		menuBar.add(spinner_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 906, 472);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		currentComponent = contentPane;

	}

}
