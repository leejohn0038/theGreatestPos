package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.actions.employees_actions.main.TableSelectData;
import project.actions.employees_actions.main.object.Emp_addData;
import project.components.customers_components.object.Cus_addData;
import project.database.employee_customer.SQLs;

public class Delete implements ActionListener{
	
	TableSelectData tsd;
	Emp_addData emp_addData;
	Cus_addData cus_addData;
	int type;
	
	public Delete(TableSelectData tsd, int type) {
		this.tsd = tsd;
		this.type = type;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object[][] dates = new SQLs("리셋", type).getRowData();
		
		if(dates.length == 1) {
			return;
		}
		
		if(type == 1) {
			emp_addData = new Emp_addData(Integer.parseInt(String.valueOf(tsd.jp.dtm.getValueAt(tsd.getRow(), 0))));
			new SQLs("삭제", null, emp_addData, type);
		}else {
			cus_addData = new Cus_addData(String.valueOf(tsd.jp.dtm.getValueAt(tsd.getRow(), 0)));
			new SQLs("삭제", null, cus_addData, type);
		}
		
		tsd.jp.dtm.removeRow(tsd.getRow());
	}
}
