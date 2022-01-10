package project.actions.customers_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CustomersSelectBtn extends JButton{
	public CustomersSelectBtn() {
		super("°Ë»ö");
		
		setBounds(0,0,100,30);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
