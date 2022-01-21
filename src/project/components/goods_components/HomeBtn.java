package project.components.goods_components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class HomeBtn extends BasicSmallButton {

	public HomeBtn(JFrame frame, ImageIcon img) {
		super(img);
		setLocation(690, 0);
		setSize(60, 25);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
	}
}
