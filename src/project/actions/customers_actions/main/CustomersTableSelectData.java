package project.actions.customers_actions.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import project.actions.customers_actions.CustomersSQLs;
import project.components.customers_components.Table_ctm;
import project.frames.customers_frames.UpdataCustomers;

public class CustomersTableSelectData implements MouseListener{
	
	public Table_ctm jp;
	JTable jt;
	CustomersSQLs sql;
	int row, col;
	
	public CustomersTableSelectData(Table_ctm jp, JTable jt, CustomersSQLs sql) {
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
			new UpdataCustomers(jp, sql, row).setVisible(true);
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
