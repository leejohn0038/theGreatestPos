package project.components.customers_components;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.actions.customers_actions.CustomersSQLs;
import project.actions.customers_actions.main.CustomersTopInnerTopBtn;
import project.components.customers_components.Table_ctm;

public class CustomersNavLayout extends JPanel{
	
	public CustomersNavLayout(Table_ctm jp, int lL_w, int lR_w, int height, CustomersSQLs sql) {
		
		for(int i = 0; i<2; i++) {
			add(new CustomersTopInnerTopBtn(jp, i, height, sql));
		}
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setBounds(lL_w, 0, lR_w, height);
		setBorder(new LineBorder(Color.black));
		
	}
}