package edu.java.gui03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class Test {

	private JFrame frame;
	private JTextField textInputName;
	private JTextField textInputPhone;
	private JTextField textInputEmail;
	private JTextField textshowInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
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
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 466, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel namelbl = new JLabel("이름");
		namelbl.setOpaque(true);
		namelbl.setBackground(Color.PINK);
		namelbl.setFont(new Font("궁서체", Font.PLAIN, 30));
		namelbl.setHorizontalAlignment(SwingConstants.CENTER);
		namelbl.setBounds(12, 10, 174, 70);
		frame.getContentPane().add(namelbl);
		
		JLabel phonelbl = new JLabel("전화번호");
		phonelbl.setOpaque(true);
		phonelbl.setForeground(Color.BLACK);
		phonelbl.setBackground(Color.ORANGE);
		phonelbl.setHorizontalAlignment(SwingConstants.CENTER);
		phonelbl.setFont(new Font("궁서체", Font.PLAIN, 30));
		phonelbl.setBounds(12, 90, 174, 70);
		frame.getContentPane().add(phonelbl);
		
		JLabel emaillbl = new JLabel("이메일");
		emaillbl.setOpaque(true);
		emaillbl.setBackground(new Color(100, 149, 237));
		emaillbl.setFont(new Font("궁서체", Font.PLAIN, 30));
		emaillbl.setHorizontalAlignment(SwingConstants.CENTER);
		emaillbl.setBounds(12, 170, 174, 70);
		frame.getContentPane().add(emaillbl);
		
		textInputName = new JTextField();
		textInputName.setBounds(198, 10, 240, 70);
		textInputName.setFont(new Font("궁서체", Font.PLAIN, 18));
		frame.getContentPane().add(textInputName);
		textInputName.setColumns(10);
		
		textInputPhone = new JTextField();
		textInputPhone.setBounds(198, 90, 240, 70);
		textInputPhone.setFont(new Font("궁서체", Font.PLAIN, 18));
		frame.getContentPane().add(textInputPhone);
		textInputPhone.setColumns(10);
		
		textInputEmail = new JTextField();
		textInputEmail.setBounds(198, 169, 240, 70);
		textInputEmail.setFont(new Font("궁서체", Font.PLAIN, 18));
		frame.getContentPane().add(textInputEmail);
		textInputEmail.setColumns(10);
		
		textshowInfo = new JTextField();
		textshowInfo.setBounds(12, 330, 426, 70);
		textshowInfo.setFont(new Font("궁서체", Font.PLAIN, 18));
		frame.getContentPane().add(textshowInfo);
		textshowInfo.setColumns(10);
		
		JButton btnshowinfo = new JButton("정보 출력");
		btnshowinfo.setOpaque(false);
		btnshowinfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 버튼을 클릭하면
				// JTextField에 입력된 내용을 읽어서(가져와서)
				// JLabel에 출력(쓰기)
				String msgname = ("이름 : " + textInputName.getText() + ", 전화번호 : " + textInputPhone.getText() + ", 이메일 : " + textInputEmail.getText());
				textshowInfo.setText(msgname);
			}
		});
		
		btnshowinfo.setBackground(new Color(102, 205, 170));
		btnshowinfo.setFont(new Font("궁서체", Font.PLAIN, 24));		
		btnshowinfo.setBounds(12, 250, 426, 70);
		frame.getContentPane().add(btnshowinfo);
		
		
	}
}
