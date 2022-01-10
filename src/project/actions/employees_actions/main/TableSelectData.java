package project.actions.employees_actions.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import project.actions.employees_actions.FrameVisible;
import project.actions.employees_actions.SQLs;
import project.components.employees_companents.Table_layout;
import project.frames.employees_frames.UpdataEmployees;

public class TableSelectData implements MouseListener{

	JTable jt;
	SQLs sql;
	int row, col;
	
	public TableSelectData(JTable jt, SQLs sql) {
		this.sql = sql;
		this.jt = jt;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			row = jt.getSelectedRow();
			col = jt.getSelectedColumn();
			System.out.println(row + " " + col);
			sql.setUpdataRow(row, col);
			new UpdataEmployees(sql).setVisible(true);;
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
	
	
	void upDate() {
	}
	
	public int getColumn() {
		return col;
	}
	
	public int getRow() {
		return row;
	}
}
