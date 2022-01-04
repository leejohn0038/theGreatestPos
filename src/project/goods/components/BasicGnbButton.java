package project.goods.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BasicGnbButton extends JButton {

	public BasicGnbButton(String btn) {
		setText(btn);
		setFont(Font.getFont("µ¸À½"));
		setSize(100, 50);
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createLineBorder(Color.BLACK, 1)
				));
		setMargin(new Insets(0, 0, 0, 0));
		setVisible(true);
	}
}
