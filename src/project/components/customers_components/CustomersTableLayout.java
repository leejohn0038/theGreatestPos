package project.components.customers_components;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import project.actions.customers_actions.main.CustomersTableSelectData;

public class CustomersTableLayout extends JPanel{
	
	DefaultTableModel dtm;
	
	public CustomersTableLayout(int lw) {
		String[] columnNames = {"phone", "customers_name", "customers_address", "subscription_date", "membership_point"};
		Object[][] rowData = {
				{"010-0505-2917", "이요한", "경기도", "2022/01/11", "100"},
				{"010-0505-2407", "장은철", "경기도", "2022/01/10", "1000"},
				{"010-0505-2557", "박찬호", "경기도", "2022/01/01", "500"},
				{"010-0504-2547", "이정호", "경기도", "2022/01/02", "100"}
				};
		JTable jt;
		JScrollPane sp;
		
		dtm = new DefaultTableModel(rowData, columnNames);
		jt = new JTable(dtm);
		sp = new JScrollPane(jt);
		
		jt.addMouseListener(new CustomersTableSelectData(jt));
		
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
