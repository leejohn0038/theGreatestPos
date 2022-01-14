package project.components.employees_companents;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import project.actions.employees_actions.SQLs;
import project.actions.employees_actions.main.TableSelectData;

public class Table_emp extends JTable{
	
	public DefaultTableModel dtm;
	JTable jt;
	JPanel jp;
	JScrollPane sp;
	Object[][] rowData;
	TableSelectData tsd;
	
	public Table_emp(JPanel jp, SQLs sql) {
		this.jp = jp;	
		resetTable(sql);
	}
	
	public void resetTable(SQLs sql) {
		String[] columnNames = new SQLs("리셋", null, null).getTitle();
		rowData = sql.getRowData();

		//테이블 자체적으로 수정 금지
		dtm = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int i, int c){ 
				return false; 
			}
		};
		
		jt = new JTable(dtm);
		sp = new JScrollPane(jt);
		tsd = new TableSelectData(this, jt, sql);
		jt.addMouseListener(tsd);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		jp.setLayout(new BorderLayout());
		jp.add(sp, "Center");
	}
	
	public JScrollPane getSp() {
		return sp;
	}
	
	public DefaultTableModel getDtm() {
		return dtm;
	}
	
	public TableSelectData getTsd() {
		return tsd;
	}
}
