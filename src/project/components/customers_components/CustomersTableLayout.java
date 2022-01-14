package project.components.customers_components;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import project.actions.customers_actions.main.CustomersTableSelectData;
import project.actions.customers_actions.CustomersSQLs;
import project.components.customers_components.Table_ctm;

public class CustomersTableLayout extends JPanel{
	
	Table_ctm jt;
	DefaultTableModel dtm;
	
	public CustomersTableLayout(int lw, CustomersSQLs sql) {	
		
		jt = new Table_ctm(this, sql);
		dtm = jt.getDtm();
		
		//add(jt.getSp(), "Center");
		setBounds(lw, 30, 1000-lw, 490);
		setVisible(true);
		
	}
	
	public void addRowData(Object[] obj) {
		dtm.addRow(obj);
	}
	
	public Table_ctm get_table() {
		return jt;
	}
}
