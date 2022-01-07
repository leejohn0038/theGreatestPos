package project.components.goods_components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BasicPopupPanel extends JPanel {

	public BasicPopupPanel() {
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(50, 100, 300, 300);
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createLineBorder(Color.BLACK, 1)
				));
		setVisible(false);
	}
}
