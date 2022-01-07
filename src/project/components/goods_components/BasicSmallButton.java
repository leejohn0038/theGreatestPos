package project.components.goods_components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BasicSmallButton extends JButton {

	public BasicSmallButton(String name) {
		setText(name);
		setSize(60, 25);
		setFont(Font.getFont("����"));
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createLineBorder(Color.BLACK, 1)
				));
		setMargin(new Insets(0, 0, 0, 0));
	}
}
