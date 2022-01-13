package project.components.receipts_components;

import java.awt.BorderLayout;
import java.util.ArrayList;

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
	
	public Tables(String[] columnName, int xPos, int yPos, int xSize, int ySize) {
		setLayout(new BorderLayout());
		setBounds(xPos, yPos, xSize, ySize);
		
		model = new DefaultTableModel(rowData, columnName);
		table = new JTable(model);
		table.setRowSelectionAllowed(true);
		sp = new JScrollPane(table);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(sp);
	}
	
	public void updateRow (ArrayList<Object[]> results) {
		removeRow();
        for (int i = 0; i < results.size(); ++i) {
        	model.addRow(results.get(i));
        }
  
	}
	
	public void removeRow() {
		int cnt = model.getRowCount();
		for (int i = cnt - 1; i >= 0; --i) {
			model.removeRow(i);
		}
	}
	
	public void getSelected() {
		table.getSelectedRow();
	}
	
	public JTable getTable() {
		return table;
	}
}
