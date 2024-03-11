package edu.java.gui02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiMain02 {

	private JFrame frame;
	private JTextField textInput;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain02 window = new GuiMain02();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOutput = new JLabel("오늘은 월요일이다.");
		lblOutput.setFont(new Font("궁서체", Font.PLAIN, 18));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setForeground(Color.RED);
		lblOutput.setBounds(12, 10, 410, 42);
		frame.getContentPane().add(lblOutput);
		
		/* 이벤트 리스너에서 접근하는 변수들은(정확하게는 객체)
		 * 멤버 변수로 선언하는 것이 좋음
		 */		
		textInput = new JTextField();
		textInput.setBounds(12, 87, 410, 59);
		textInput.setFont(new Font("궁서체", Font.PLAIN, 18));
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		JButton btnInput = new JButton("입력");
		btnInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 버튼을 클릭하면
				// JTextField에 입력된 내용을 읽어서(가져와서)
				// JLabel에 출력(쓰기)
				String msg = textInput.getText();
				System.out.println(msg);
				lblOutput.setText(msg);			
			}
		});
		
		btnInput.setBounds(12, 179, 410, 48);
		frame.getContentPane().add(btnInput);
		btnInput.setFont(new Font("굴림", Font.PLAIN, 18));
		
		System.out.println("initialize 메소드 호출 끝");
		
		
		
	} // end initialize
} // end GuiMain02
