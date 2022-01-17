package project.components.employees_companents;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import project.database.employee_customer.SQLs;

public class Table_layout extends JPanel{
	
	Table jt;
	DefaultTableModel dtm;
	
	public Table_layout(int lw, SQLs sql, int type) {	
		
		jt = new Table(this, sql, type);
		dtm = jt.getDtm();
		
		//add(jt.getSp(), "Center");
		setBounds(lw, 30, 1000-lw, 490);
		setVisible(true);
		
	}
	
	public void addRowData(Object[] obj) {
		dtm.addRow(obj);
	}
	
	public Table get_table() {
		return jt;
	}
}
