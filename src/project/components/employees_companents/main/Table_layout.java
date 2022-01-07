package project.components.employees_companents.main;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import project.actions.employees_actions.main.SQLs;
import project.actions.employees_actions.main.TableSelectData;

public class Table_layout extends JPanel{
	
	DefaultTableModel dtm;
	
	public Table_layout(int lw) {
		final SQLs DB_DATA = new SQLs(null); 
		String[] columnNames = DB_DATA.getTitle();
		Object[][] rowData = DB_DATA.getRowData();
		JTable jt;
		JScrollPane sp;
		
		//new SQLs(null);
		
		dtm = new DefaultTableModel(rowData, columnNames);
		jt = new JTable(dtm);
		sp = new JScrollPane(jt);
		
		jt.addMouseListener(new TableSelectData(jt));
		
		setLayout(new BorderLayout());	
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		add(sp, "Center");
		
		setBounds(lw, 30, 1000-lw, 490);
		setVisible(true);
	}
	
	public void addRowData(Object[] obj) {
		dtm.addRow(obj);
	}
}
