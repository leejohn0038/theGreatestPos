package project.actions.employees_actions.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import project.components.employees_companents.Table;
import project.database.employee_customer.SQLs;
import project.frames.employees_frames.UpdataEmployees;

public class TableSelectData implements MouseListener{
	
	public Table jp;
	JTable jt;
	int row, col;
	int type;
	
	public TableSelectData(Table jp, JTable jt, int type) {
		this.jp = jp;
		this.jt = jt;
		this.type = type;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		row = jt.getSelectedRow();
		col = jt.getSelectedColumn();
		
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			SQLs reset = new SQLs("¸®¼Â",1);
			reset.setUpdataRow(row, col);
			new UpdataEmployees(jp, reset, row, type).setVisible(true);
		}

	}
	
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	
	public int getColumn() {
		return col;
	}
	
	public int getRow() {
		return row;
	}
}
