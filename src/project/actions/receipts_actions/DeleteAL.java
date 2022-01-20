package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.MainFrame;
import project.components.receipts_components.Tables;

public class DeleteAL implements ActionListener{

	MainFrame main;
	
	public DeleteAL(MainFrame main) {
		this.main = main;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Tables table = main.getTable();
		int row = main.getJTable().getSelectedRow();
		table.removeRow(row);
	}

}
