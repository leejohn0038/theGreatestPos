package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.actions.employees_actions.main.object.AddData;

public class Delete implements ActionListener{
	
	AddData addData;
	
	public Delete(int row) {}

	/*
	AddData getData() {
		addData = new AddData(Integer.parseInt(String.valueOf(data[0])), 
				(String)data[1], LocalDate.parse((String)data[2], DateTimeFormatter.ISO_DATE), 
				(String)data[3], (String)data[4]);
		return addData;
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		new SQLs("ªË¡¶", null, null);
		
	}
}
