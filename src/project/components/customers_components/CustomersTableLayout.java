package project.components.customers_components;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import project.actions.employees_actions.main.TableSelectData;

public class CustomersTableLayout extends JPanel{
	
	DefaultTableModel dtm;
	
	public CustomersTableLayout(int lw) {
		String[] columnNames = {"ID", "이름", "전화번호", "주소", "직책"};
		Object[][] rowData = {
				{100, "이요한", "010-0505-2247", "경기도", "팀장"},
				{101, "장은철", "010-0505-2247", "경기도", "팀원"},
				{102, "박찬호", "010-0505-2247", "경기도", "팀원"},
				{103, "이정호", "010-0505-2247", "경기도", "팀원"}
				};
		JTable jt;
		JScrollPane sp;
		
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
