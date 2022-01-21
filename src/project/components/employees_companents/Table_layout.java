package project.components.employees_companents;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import project.database.employee_customer.SQLs;

public class Table_layout extends JPanel{
	
	Table jt;
	DefaultTableModel dtm;
	
	public Table_layout(int lw, int lh, SQLs sql, int type, ArrayList<JFrame> fs) {	
		
		lw = lw+30;
		setBounds(lw, lh+10, 1000-lw-30, 300);
		System.out.println(lh);
		setVisible(true);
		
		jt = new Table(this, sql, type, fs);
		dtm = jt.getDtm();	
	}
	
	public void addRowData(Object[] obj) {
		dtm.addRow(obj);
	}
	
	public Table get_table() {
		return jt;
	}
}
