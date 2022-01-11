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
	JFrame emp_f;
	
	public Table_layout(JFrame emp_f, int lw, SQLs sql) {
		String[] columnNames = {"ID", "이름", "입사일", "전화번호", "직책"};
		Object[][] rowData = sql.getRowData();
		JTable jt;
		this.emp_f = emp_f;
		
		JScrollPane sp;
		
		//테이블 자체적으로 수정 금지
		dtm = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int i, int c){ 
				return false; 
			}
		};
		jt = new JTable(dtm);
		sp = new JScrollPane(jt);
		
		jt.addMouseListener(new TableSelectData(jt, dtm, sql));
		
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
