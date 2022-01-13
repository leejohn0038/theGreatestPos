package project.actions.customers_actions.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import project.components.customers_components.CustomersTableLayout;

public class CustomersTableSelectData implements MouseListener{

	JTable jt;
	int row, column;
	
	public CustomersTableSelectData(JTable jt) {
		this.jt = jt;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		row = jt.getSelectedRow();
		column = jt.getSelectedColumn();
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getRow() {
		return row;
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
