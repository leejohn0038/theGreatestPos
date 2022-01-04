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
	
	public Toppanel(String name) {
		textField = new JTextField();
		label = new JLabel(name);
		btn = new JButton("°Ë»ö");
		
		label.setBounds(0, 20, 150, 40);
		label.setFont(new Font("µ¸À½", Font.BOLD, 30));
		textField.setBounds(500, 20, 270, 40);
		btn.setBounds(800, 20, 70, 40);
		
		add(label);
		add(textField);
		add(btn);
		setBounds(100, 0, 930, 100);
		setLayout(null);		
	}
}
