package project.components.employees_companents;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import project.actions.employees_actions.SQLs;
import project.actions.employees_actions.main.TableSelectData;

public class Table_layout extends JPanel{
	
	DefaultTableModel dtm;
	
	public Table_layout(int lw, SQLs sql) {
		
		Table_emp jt;
		
		jt = new Table_emp(this, sql);
		dtm = jt.getDtm();
		
		//add(jt.getSp(), "Center");
		setBounds(lw, 30, 1000-lw, 490);
		setVisible(true);
		
	}
	
	public void addRowData(Object[] obj) {
		dtm.addRow(obj);
	}
}
