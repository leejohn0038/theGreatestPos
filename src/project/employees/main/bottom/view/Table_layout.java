package project.employees.main.bottom.view;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import project.employees.main.bottom.actions.TableSelectData;

public class Table_layout extends JPanel{
	
	DefaultTableModel dtm;
	
	public Table_layout(int lw) {
		String[] columnNames = {"ID", "�̸�", "��ȭ��ȣ", "�ּ�", "��å"};
		Object[][] rowData = {
				{100, "�̿���", "010-0505-2247", "��⵵", "����"},
				{101, "����ö", "010-0505-2247", "��⵵", "����"},
				{102, "����ȣ", "010-0505-2247", "��⵵", "����"},
				{103, "����ȣ", "010-0505-2247", "��⵵", "����"}
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
