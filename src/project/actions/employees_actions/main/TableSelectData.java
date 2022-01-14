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
	int row, col;
	
	public TableSelectData(Table_emp jp, JTable jt) {
		this.jp = jp;
		this.jt = jt;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		row = jt.getSelectedRow();
		col = jt.getSelectedColumn();
		
		System.out.println(jp.dtm.getValueAt(row, 0));
		
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			SQLs reset = new SQLs("¸®¼Â",null,null);
			reset.setUpdataRow(row, col);
			new UpdataEmployees(jp, reset, row).setVisible(true);
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
