package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.actions.employees_actions.main.TableSelectData;
import project.actions.employees_actions.main.object.Emp_addData;
import project.database.employee_customer.SQLs;

public class Delete implements ActionListener{
	
	Emp_addData addData;
	TableSelectData tsd;
	
	public Delete(TableSelectData tsd) {
		this.tsd = tsd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[][] dates = new SQLs("리셋", 1).getRowData();
		
		addData = new Emp_addData(Integer.parseInt(String.valueOf(tsd.jp.dtm.getValueAt(tsd.getRow(), 0))));
		new SQLs("삭제", null, addData, 1);
		tsd.jp.dtm.removeRow(tsd.getRow());
	}
}
