package project.components.receipts_components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import project.components.goods_components.BasicSmallButton;

public class homeBtn extends BasicSmallButton {

	public homeBtn(JFrame frame, ImageIcon img) {
		super(img);
		setBounds(930, 10, 60, 25);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
	}

}
