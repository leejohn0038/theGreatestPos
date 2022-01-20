package project.components.goods_components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BasicPopupPanel extends JPanel {

	public BasicPopupPanel() {
		setLayout(null);
//		setBackground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 510, 570, 130);
//		setBorder(BorderFactory.createCompoundBorder(
//				BorderFactory.createLineBorder(Color.BLACK, 0),
//				BorderFactory.createLineBorder(Color.BLACK, 1)
//				));
		setVisible(false);
	}
}
