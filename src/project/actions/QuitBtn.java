package project.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class QuitBtn extends JButton{
	
	private int x, y, width, hight, padding;
	
	public QuitBtn(JFrame now_f, JFrame past_f) {
		
		width = 100;
		hight = 50;
		padding = 20;
		
		x = (now_f.getSize().width - width) - padding;
		y = padding;
		
		setText("Á¾·á");
		setBounds(x, y, width, hight);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				now_f.dispose();
				past_f.setVisible(true);
			}
		});
	}
	
	public int getHight() {
		return hight + y + padding;
	}
}
