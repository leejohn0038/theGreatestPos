package project.employees.main.bottom.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import project.employees.main.bottom.view.Table_layout;

public class TableSelectData implements MouseListener{

	JTable jt;
	int row, column;
	
	public TableSelectData(JTable jt) {
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
