package project.components.employees.Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SelectBtn extends JButton{
	public SelectBtn() {
		super("°Ë»ö");
		
		setBounds(0,0,100,30);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
