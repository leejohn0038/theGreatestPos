package project.components.employees.main.bottom.Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import project.components.employees.main.bottom.view.Table_layout;

public class TableSelectData implements MouseListener{

	JTable jt;
	
	public TableSelectData(JTable jt) {
		this.jt = jt;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = jt.getSelectedRow();
		int column = jt.getSelectedColumn();
		System.out.print(jt.getSelectedRow() + " ");
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
