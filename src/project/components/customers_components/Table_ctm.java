package project.components.customers_components;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import project.actions.customers_actions.CustomersSQLs;
import project.actions.customers_actions.main.CustomersTableSelectData;
import project.actions.employees_actions.main.TableSelectData;

public class Table_ctm extends JTable{
	
	public DefaultTableModel dtm;
	JTable jt;
	JPanel jp;
	JScrollPane sp;
	Object[][] rowData;
	CustomersTableSelectData tsd;
	
	public Table_ctm(JPanel jp, CustomersSQLs sql) {
		this.jp = jp;	
		resetTable(sql);
	}
	
	public void resetTable(CustomersSQLs sql) {
		String[] columnNames = new CustomersSQLs("리셋", null, null).getTitle();
		rowData = sql.getRowData();

		//테이블 자체적으로 수정 금지
		dtm = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int i, int c){ 
				return false; 
			}
		};
		
		jt = new JTable(dtm);
		sp = new JScrollPane(jt);
		tsd = new CustomersTableSelectData(this, jt, sql);
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
	
	public CustomersTableSelectData getTsd() {
		return tsd;
	}
}
