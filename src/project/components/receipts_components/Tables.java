package project.components.receipts_components;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class Tables extends JPanel {

	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	String[][] rowData = {};
	
	public Tables(String[] columnName) {
		setLayout(new BorderLayout());
		setBounds(300, 100, 680, 300);
		
		model = new DefaultTableModel(rowData, columnName);
		table = new JTable(model);
		sp = new JScrollPane(table);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(sp);
	}
	// 오버로딩으로 테이브 위치 및 크기 조정 가능
	public Tables(String[] columnName, int xPos, int yPos, int ySize) {
		setLayout(new BorderLayout());
		setBounds(xPos, yPos, 680, ySize);
		
		model = new DefaultTableModel(rowData, columnName);
		table = new JTable(model);
		sp = new JScrollPane(table);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(sp);
	}
	
	public void tableUpdate(Object[] result) {
        model.addRow(result);
	}
}
