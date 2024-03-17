package edu.java.project;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PCManagePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PCManagePanel() {
		
		setBounds(100, 100, 862, 641);
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(12, 10, 146, 80);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(170, 10, 146, 80);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(328, 10, 146, 80);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(486, 10, 146, 80);
		add(btnNewButton_3);

	}

}
