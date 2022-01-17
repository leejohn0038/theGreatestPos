package project.actions.customers_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.actions.customers_actions.CustomersSQLs;
import project.actions.customers_actions.main.CustomersTableSelectData;
import project.actions.customers_actions.main.object.CustomersAddData;

public class CustomersDelete implements ActionListener{
	
	CustomersAddData addData;
	CustomersTableSelectData tsd;
	
	public CustomersDelete(CustomersTableSelectData tsd) {
		this.tsd = tsd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[][] dates = new CustomersSQLs("리셋", null, null).getRowData();
		
		
		addData = new CustomersAddData(Integer.parseInt(String.valueOf(dates[tsd.getRow()][0])));
		new CustomersSQLs("삭제", null, addData);
		tsd.jp.dtm.removeRow(tsd.getRow());
	}
}
