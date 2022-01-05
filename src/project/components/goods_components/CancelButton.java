package project.components.goods_components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CancelButton extends JButton {

	public CancelButton(JPanel panel, int x, int y) {
		setText("Ãë¼Ò");
		setSize(60, 25);
		setFont(Font.getFont("µ¸¿ò"));
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createLineBorder(Color.BLACK, 1)
				));
		setMargin(new Insets(0, 0, 0, 0));
		setLocation(x, y);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
			}
		});
	}
}
