package project.components;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Toppanel extends JPanel{
	
	public Toppanel(String name) {
		
		add(new Label(name, 0, 20, 300, 40) {
			{
				setFont(new Font("����", Font.BOLD, 30));
			}
		});
		add(new TextField(500, 20, 270, 40));
		add(new Button("�˻�", 800, 20, 70, 40));
		setBounds(100, 0, 930, 100);
		setLayout(null);		
	}
}
