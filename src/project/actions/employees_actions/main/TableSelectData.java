package project.actions.employees_actions.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;

import project.components.employees_companents.Table;
import project.components.employees_companents.Table_layout;
import project.database.employee_customer.SQLs;
import project.frames.employees_frames.UpdataEmployees;

public class TableSelectData implements MouseListener{
	
	public Table jp;
	Table_layout tl;
	JTable jt;
	int row, col;
	int type;
	int[] size;
	ArrayList<JFrame> fs;
	
	public TableSelectData(Table_layout tl, Table jp, JTable jt, int type, int[] size, ArrayList<JFrame> fs) {
		this.tl = tl;
		this.jp = jp;
		this.jt = jt;
		this.type = type;
		this.fs = fs;
		this.size = size;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		row = jt.getSelectedRow();
		col = jt.getSelectedColumn();
		
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			SQLs reset = new SQLs("¸®¼Â",1);
			reset.setUpdataRow(row, col);
			new UpdataEmployees(tl, jp, reset, row, type, fs).setVisible(true);
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
