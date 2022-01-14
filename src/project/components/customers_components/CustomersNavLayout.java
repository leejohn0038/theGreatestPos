package project.components.customers_components;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.actions.employees_actions.main.TopInnerTop_Btn;

public class CustomersNavLayout extends JPanel{
	
	public CustomersNavLayout(int lL_w, int lR_w, int height) {
		
		for(int i = 0; i<2; i++) {
			add(new TopInnerTop_Btn(i, height));
		}
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setBounds(lL_w, 0, lR_w, height);
		setBorder(new LineBorder(Color.black));
		
	}
}