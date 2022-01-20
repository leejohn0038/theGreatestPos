package project.components.receipts_components;

import java.awt.Font;

import javax.swing.JPanel;

import project.MainFrame;

public class Toppanel extends JPanel{
	
	public Toppanel (String name) {
			add(new Label(name, 0, 20, 300, 40) {{setFont(new Font("±âº»", Font.BOLD, 30));}});
			setBounds(100, 0, 930, 100);
			setLayout(null);		
		}
}
