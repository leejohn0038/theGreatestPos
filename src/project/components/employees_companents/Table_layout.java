package project.components.employees_companents;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import project.database.employee_customer.SQLs;

public class Table_layout extends JPanel{
	
	Table jt;
	DefaultTableModel dtm;
	
	public Table_layout(int lw, int lh, SQLs sql, int type) {	
		
		setBorder(new LineBorder(Color.black));
		setBounds(lw, lh, 1000-lw, 300);
		setVisible(true);
		
		jt = new Table(this, sql, type);
		dtm = jt.getDtm();
		
	}
	
	public void addRowData(Object[] obj) {
		dtm.addRow(obj);
	}
	
	public Table get_table() {
		return jt;
	}
}
