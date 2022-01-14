package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.actions.employees_actions.main.TableSelectData;
import project.actions.employees_actions.main.object.AddData;

public class Delete implements ActionListener{
	
	AddData addData;
	TableSelectData tsd;
	
	public Delete(TableSelectData tsd) {
		this.tsd = tsd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[][] dates = new SQLs("리셋", null, null).getRowData();
		
		
		addData = new AddData(Integer.parseInt(String.valueOf(dates[tsd.getRow()][0])));
		new SQLs("삭제", null, addData);
		tsd.jp.dtm.removeRow(tsd.getRow());
	}
}
