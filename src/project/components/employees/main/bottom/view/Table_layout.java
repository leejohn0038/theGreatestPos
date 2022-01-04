package project.components.employees.main.bottom.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

public class Table_layout extends JPanel{
	public Table_layout(int lw) {
		String[] columnNames = {
				"ID", "�̸�", "��ȭ��ȣ", "�ּ�", "��å"
		};
		Object[][] rowData = {
				{"100", "�̿���", "010-0505-2247", "��⵵", "����"},
				{"101", "����ö", "010-0505-2247", "������", "����"},
				{"102", "����ȣ", "010-0505-2247", "���ϵ�", "����"},
				{"103", "����ö", "010-0505-2247", "���󳲵�", "����"}
				};
		
		// ���̺��� ScrollPane�� �ٿ��� ���� ����.
		JTable jt;
		JScrollPane sp;
		DefaultTableModel dtm;
		
		dtm = new DefaultTableModel(rowData, columnNames);
		jt = new JTable(dtm);
		sp = new JScrollPane(jt);
		
		setLayout(new BorderLayout());	
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		add(sp, "Center");
		
		/*
 			�߰��� �� addRow() / �����Ҷ� removeRow() 
		 */
		
		setBounds(lw, 30, 1000-lw, 490);
		setVisible(true);
	}
}
