package project.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class QuitBtn extends JButton{
	
	private int x, y, width, hight, padding;
	
	private ArrayList<JFrame> fs;
	private JFrame past_f;
	
	public QuitBtn(ArrayList<JFrame> fs, JFrame past_f) {
		this.fs = fs;
		this.past_f = past_f;
		
		clean();
	}
	
	public QuitBtn(JFrame now_f, JFrame past_f) {
		fs = new ArrayList<>();
		fs.add(now_f);
		this.past_f = past_f;
		
		clean();
	}
	
	public void clean() {
		width = 100;
		hight = 50;
		padding = 20;
		
		x = (fs.get(0).getSize().width - width) - padding;
		y = padding;
		
		setText("Á¾·á");
		setBounds(x, y, width, hight);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i<fs.size(); i++) {
					fs.get(i).dispose();
				}
				past_f.setVisible(true);
			}
		});
	}
	
	public int getHight() {
		return hight + y + padding;
	}
}
