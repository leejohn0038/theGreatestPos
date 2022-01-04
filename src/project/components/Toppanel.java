package project.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Toppanel extends JPanel{
	
	JTextField textField;
	JLabel label;
	JButton btn;
	
	public Toppanel() {
		textField = new JTextField();
		label = new JLabel("  판매");
		btn = new JButton("검색");
		
		label.setBounds(50, 20, 100, 40);
		label.setFont(new Font("돋음", Font.BOLD, 30));
		textField.setBounds(600, 20, 270, 40);
		btn.setBounds(900, 20, 70, 40);
		
		add(label);
		add(textField);
		add(btn);
		setBounds(0, 0, 1000, 100);
		setLayout(null);
	}
}
