package project.components.receipts_components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import project.MainFrame;
import project.actions.receipts_actions.TableAL;

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
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setForeground(Color.WHITE);
		sp.getViewport().setBackground(Color.WHITE);
		add(sp);
	}
	
	public void updateRows (ArrayList<Object[]> results) {
		removeRows();
        for (int i = 0; i < results.size(); ++i) {
        	model.addRow(results.get(i));
        }
  
	}
	
	public void removeRows() {
		int cnt = model.getRowCount();
		for (int i = cnt - 1; i >= 0; --i) {
			model.removeRow(i);
		}
	}
	
	public void removeRow(int index) {
		model.removeRow(index);
	}
	
	public void addRow(Object[] result) {
		model.addRow(result);
	}
	
	public JTable getTable() {
		return table;
	}
}
