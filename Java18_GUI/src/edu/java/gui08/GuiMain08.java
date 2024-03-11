package edu.java.gui08;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuiMain08 {

	private JFrame frame;
	
	private static final ImageIcon[] IMAGE_ICONS = {
			new ImageIcon("res/dog1.jpg"),
			new ImageIcon("res/dog2.jpg"),
			new ImageIcon("res/dog3.jpg"),
			new ImageIcon("res/dog4.jpg")
			
	};
	
	private int index = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain08 window = new GuiMain08();
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
	public GuiMain08() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOutput = new JLabel();
		lblOutput.setIcon(IMAGE_ICONS[0]);
		lblOutput.setBounds(12, 10, 410, 209);
		frame.getContentPane().add(lblOutput);
		
		JButton button = new JButton("New button");
		button.setBounds(12, 478, 166, -166);
		frame.getContentPane().add(button);
		
		JButton btnPrev = new JButton("이전");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index > 0) {
					index--;					
				} else {
					index = IMAGE_ICONS.length - 1;
				}
				lblOutput.setIcon(IMAGE_ICONS[index]);
			}
		});
		btnPrev.setBounds(12, 260, 198, 241);
		frame.getContentPane().add(btnPrev);
		
		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index++;
				if(index > IMAGE_ICONS.length - 1) {
					index = 0;					
				}
				lblOutput.setIcon(IMAGE_ICONS[index]);
			}
		});
		
		btnNext.setBounds(224, 260, 198, 241);
		frame.getContentPane().add(btnNext);		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					double rX = Math.random();
					int x = (int)(IMAGE_ICONS.length * rX);
					lblOutput.setIcon(IMAGE_ICONS[x]);
			}
		});		
		btnNewButton.setBounds(170, 227, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
	}	

}
