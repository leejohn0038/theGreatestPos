package project.components.employees_companents;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import project.actions.employees_actions.main.TableSelectData;
import project.database.employee_customer.SQLs;

public class Table extends JTable{
	
	public DefaultTableModel dtm;
	JTable jt;
	Table_layout jp;
	JScrollPane sp;
	Object[][] rowData;
	TableSelectData tsd;
	
	int[] size;
	ArrayList<JFrame> fs;
	int type;
	
	public Table(Table_layout tl, SQLs sql, int type, ArrayList<JFrame> fs) {
		this.type = type;
		this.jp = tl;	
		this.fs = fs;
		
		resetTable(sql);
	}
	
	public void resetTable(SQLs sql) {
		
		String[] columnNames = new SQLs("����", type).getTitle();
		rowData = sql.getRowData();

		//���̺� ��ü������ ���� ����
		dtm = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int i, int c){ 
				return false; 
			}
		};
		
		jt = new JTable(dtm);
		sp = new JScrollPane(jt);
		tsd = new TableSelectData(jp, this, jt, type, size, fs);
		jt.addMouseListener(tsd);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		// DefaultTableCellHeaderRenderer ���� (��� ������ ����)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();

		// DefaultTableCellHeaderRenderer�� ������ ��� ���ķ� ����
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// ������ ���̺��� ColumnModel�� ������
		TableColumnModel tcmSchedule = jt.getColumnModel();

		// �ݺ����� �̿��Ͽ� ���̺��� ��� ���ķ� ����
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		
		jp.setLayout(new BorderLayout());
		jp.add(sp,"Center");
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
