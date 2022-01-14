package project.actions.employees_actions.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import project.actions.employees_actions.SQLs;
import project.components.employees_companents.Table_emp;
import project.frames.employees_frames.UpdataEmployees;

public class TableSelectData implements MouseListener{
	
	public Table_emp jp;
	JTable jt;
	SQLs sql;
	int row, col;
	
	public TableSelectData(Table_emp jp, JTable jt, SQLs sql) {
		this.jp = jp;
		this.sql = sql;
		this.jt = jt;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		row = jt.getSelectedRow();
		col = jt.getSelectedColumn();
		
		if (e.getClickCount() == 2 && !e.isConsumed()) {	
			sql.setUpdataRow(row, col);
			new UpdataEmployees(jp, sql, row).setVisible(true);
		}
		//new SQLs();
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
