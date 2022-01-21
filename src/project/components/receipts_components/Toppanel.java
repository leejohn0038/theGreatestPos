package project.components.receipts_components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

public class Toppanel extends JPanel{
	
	public Toppanel (String name) {
			add(new Label(name, 0, 0, 100, 50) {{setFont(new Font("±âº»", Font.BOLD, 30));}});
			setBounds(230, 10, 100, 50);
			setBackground(Color.WHITE);
			setLayout(null);		
		}
}
