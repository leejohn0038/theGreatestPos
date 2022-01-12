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

	/*
	AddData getData() {
		addData = new AddData(Integer.parseInt(String.valueOf(data[0])), 
				(String)data[1], LocalDate.parse((String)data[2], DateTimeFormatter.ISO_DATE), 
				(String)data[3], (String)data[4]);
		return addData;
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object[][] dates = new SQLs("리셋", null, null).getRowData();
		
		for(int i = 0; i<dates.length; i++) {
			for(int j = 0; j<dates[i].length; j++) {
				System.out.print(dates[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(dates[tsd.getRow()][0]);
		
		addData = new AddData(Integer.parseInt(String.valueOf(dates[tsd.getRow()][0])));
		new SQLs("삭제", null, addData);
		tsd.jp.dtm.removeRow(tsd.getRow());
	}
}
