package project.components.goods_components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class HomeBtn extends BasicSmallButton {

	public HomeBtn(JFrame frame) {
		super("X");
		setLocation(600, 20);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
	}
}
