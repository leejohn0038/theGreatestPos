package project.components.goods_components;

import java.awt.Font;

import javax.swing.JLabel;

public class BasicLabel extends JLabel {
	
	public BasicLabel(String text) {
		
		setText(text);
		setFont(new Font("µ¸¿ò", Font.BOLD, 15));
		setSize(100, 30);
	}
}
