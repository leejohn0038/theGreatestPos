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
				"ID", "이름", "전화번호", "주소", "직책"
		};
		Object[][] rowData = {
				{"100", "이요한", "010-0505-2247", "경기도", "팀장"},
				{"101", "장은철", "010-0505-2247", "강원도", "팀원"},
				{"102", "박찬호", "010-0505-2247", "경상북도", "팀원"},
				{"103", "장은철", "010-0505-2247", "전라남도", "팀원"}
				};
		
		// 테이블은 ScrollPane에 붙여야 재대로 나옴.
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
 			추가할 땐 addRow() / 삭제할땐 removeRow() 
		 */
		
		setBounds(lw, 30, 1000-lw, 490);
		setVisible(true);
	}
}
