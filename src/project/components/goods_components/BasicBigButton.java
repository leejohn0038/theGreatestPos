package project.components.goods_components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BasicBigButton extends JButton {

	public BasicBigButton(String btn) {
		setText(btn);
		setFont(Font.getFont("µ¸¿ò"));
		setSize(100, 50);
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createLineBorder(Color.BLACK, 1)
				));
		setMargin(new Insets(0, 0, 0, 0));
		
		setVisible(true);
	}
	
	public BasicBigButton(ImageIcon img) {
		super(img);
		setFont(Font.getFont("µ¸¿ò"));
		setSize(100, 50);
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		
		
		setVisible(true);
	}
}
